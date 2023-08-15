package com.axonivy.connector.successfactors.connector.rest.odata;

import java.io.IOException;

import com.axonivy.connector.successfactors.connector.rest.SFODataCustomNavigationCreate;
import com.axonivy.connector.successfactors.connector.rest.SFODataFOJobCodeUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPositionUpsert;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Some values in the converted SuccessFactors ODATA spec are generated as empty
 * interfaces without a matching impl.
 *
 * @author jpl
 *
 */
public class SuccessFactorsTypeCustomizations extends SimpleModule {

	private static final long serialVersionUID = 4552540562745977391L;

	public SuccessFactorsTypeCustomizations() {
		addSerializer(SFODataCustomNavigationCreate.class, new CustomNavigationCreateSerializer());
		addSerializer(SFODataPositionUpsert.class, new PositionUpsertSerializer());
		addSerializer(SFODataFOJobCodeUpsert.class, new FOJobCodeUpsertSerializer());
	}

	private static class CustomNavigationCreateSerializer extends StdSerializer<SFODataCustomNavigationCreate> {

		private static final long serialVersionUID = 1L;

		@Override
		public void serialize(SFODataCustomNavigationCreate value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			generator.writeStartObject();
			generator.writeFieldName("__metadata");
			generator.writeStartObject();
			generator.writeStringField("uri", value.getMetadata().getUri());
			generator.writeEndObject();
			generator.writeEndObject();
		}

		public CustomNavigationCreateSerializer() {
			super(SFODataCustomNavigationCreate.class);
		}
	}

	private static class PositionUpsertSerializer extends StdSerializer<SFODataPositionUpsert> {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPositionUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPositionUpsert.class);
			BeanDescription beanDesc = provider.getConfig().introspect(javaType);
			JsonSerializer<Object> serializer = BeanSerializerFactory.instance.findBeanSerializer(provider, javaType,
					beanDesc);
			generator.writeStartObject();
			generator.writeFieldName("__metadata");
			generator.writeStartObject();
			generator.writeStringField("uri", value.getMetadataUri());
			generator.writeEndObject();
			value.setMetadataUri(null);
			serializer.unwrappingSerializer(null).serialize(value, generator, provider);
			generator.writeEndObject();
		}

		public PositionUpsertSerializer() {
			super(SFODataPositionUpsert.class);
		}
	}

	private static class FOJobCodeUpsertSerializer extends StdSerializer<SFODataFOJobCodeUpsert> {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataFOJobCodeUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataFOJobCodeUpsert.class);
			BeanDescription beanDesc = provider.getConfig().introspect(javaType);
			JsonSerializer<Object> serializer = BeanSerializerFactory.instance.findBeanSerializer(provider, javaType,
					beanDesc);
			generator.writeStartObject();
			generator.writeFieldName("__metadata");
			generator.writeStartObject();
			generator.writeStringField("uri", value.getMetadataUri());
			generator.writeEndObject();
			value.setMetadataUri(null);
			serializer.unwrappingSerializer(null).serialize(value, generator, provider);
			generator.writeEndObject();
		}

		public FOJobCodeUpsertSerializer() {
			super(SFODataFOJobCodeUpsert.class);
		}
	}
}
