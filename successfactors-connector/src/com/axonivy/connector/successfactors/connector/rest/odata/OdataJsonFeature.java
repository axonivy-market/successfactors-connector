package com.axonivy.connector.successfactors.connector.rest.odata;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.time.OffsetDateTime;

import javax.ws.rs.Priorities;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;

import com.axonivy.connector.successfactors.connector.rest.OpenApiJsonFeature;
import com.axonivy.connector.successfactors.connector.rest.SucessFactorsQueryStringFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * Custom Feature to handle ODATA specific JSON features
 * 
 * <ul>
 * <li>Remove or rename root entity</li>
 * <li>Load custom {@link SuccessFactorsTypeCustomizations}</li>
 * <li>Load custom {@link InnerListResolveVisitor}</li> 
 * <li>Load custom {@link OffsetDateTimeSerializer}</li>
 * <li>Load custom {@link SucessFactorsQueryStringFilter}</li> 
 * </ul>
 * 
 * So let's handle them to make object transformation possible.
 * 
 * @author jpl
 * @since 10.0.2
 */
public class OdataJsonFeature extends OpenApiJsonFeature {
	
	private static final ObjectMapper ROOT_MAPPER = new ObjectMapper();

	@Override
	public boolean configure(FeatureContext context) {
		JacksonJsonProvider provider = new SuccessFactorsJson();
		configure(provider, context.getConfiguration());
		context.register(provider, Priorities.ENTITY_CODER);
		context.register(SucessFactorsQueryStringFilter.class);
		return true;
	}

	public static class ODataMapperProvider extends JaxRsClientJson {
		
		@Override
		public Object readFrom(Class<Object> type, Type genericType,
				Annotation[] annotations, MediaType mediaType,
				MultivaluedMap<String, String> httpHeaders,
				InputStream entityStream) throws IOException {
			InputStream inputStream = unwrapValueRoot(entityStream);
			return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, inputStream);
		}

		protected InputStream unwrapValueRoot(InputStream entityStream)
				throws IOException, JsonProcessingException	{
			JsonNode node = ROOT_MAPPER.readTree(entityStream);
			node = manipulateJson(node);
			String json = ROOT_MAPPER.writeValueAsString(node);
			InputStream inputStream = IOUtils.toInputStream(json, Charset.forName("UTF-8"));
			return inputStream;
		}

		@Override
		public ObjectMapper locateMapper(Class<?> type, MediaType mediaType) {
			ObjectMapper mapper = super.locateMapper(type, mediaType);
			// odata provides fields starting with an upper case character!
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			SimpleModule module = new SimpleModule("OffsetDateTimeSerializer", new Version(1, 0, 0, null));
			module.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());
			mapper.registerModule(module);

			return mapper;
		}

		/**
		 * unwrap collections which store their value array in an internal 'value'
		 * field.
		 */
		protected JsonNode manipulateJson(JsonNode node) {
			if (node.has(Field.VALUE)) {
				if (node.get(Field.VALUE).has(Field.RESULT)) {
					node = node.get(Field.VALUE);
				}
			}
			if(node.has("results") || node.has(Field.VALUE)) {
				ObjectNode objectNode;
				try {
					if(node.isObject()) {
						objectNode = (ObjectNode) node;
						mapValueForObjectNode(objectNode);
						node = ROOT_MAPPER.readTree(objectNode.toString());
					}
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			new InnerListResolveVisitor().visitNode(node);
			return node;
		}

		/** Well known OData fields */
		private interface Field {
			String VALUE = "d";
			String RESULT = "results";
		}
		
		private  void mapValueForObjectNode (ObjectNode node) {
			if (node.has(Field.RESULT)) {
				updateValueForObjectNode(node, Field.RESULT);
			}
			if (node.has(Field.VALUE)) {
				updateValueForObjectNode(node, Field.VALUE);
			}
		}
		private static void updateValueForObjectNode(ObjectNode node, String resultField) {
			node.set("value", node.get(resultField));
			node.remove(resultField);
		}
	}

	private static class SuccessFactorsJson extends ODataMapperProvider {
		@Override
		public ObjectMapper locateMapper(Class<?> type, MediaType mediaType) {
			var mapper = super.locateMapper(type, mediaType);
			mapper.registerModule(new SuccessFactorsTypeCustomizations());
			return mapper;
		}
	}

}
