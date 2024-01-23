package com.axonivy.connector.successfactors.connector.rest.odata;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.axonivy.connector.successfactors.connector.rest.SFODataCustEMEAHRdataUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataCustomNavigationCreate;
import com.axonivy.connector.successfactors.connector.rest.SFODataEmpEmploymentUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataEmpJobRelationshipsUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataEmpJobUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataFOJobCodeUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPaymentInformationDetailV3Upsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPaymentInformationV3Upsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerAddressDEFLTUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerEmailUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerEmergencyContactsUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerGlobalInfoUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerNationalIdUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerPersonUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerPersonalUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPerPhoneUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPhotoUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataPositionUpsert;
import com.axonivy.connector.successfactors.connector.rest.SFODataUserUpsert;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import ch.ivyteam.ivy.environment.Ivy;

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
		setUpCustomSerializer(
				List.of(SFODataCustEMEAHRdataUpsert.class,
						SFODataEmpEmploymentUpsert.class,
						SFODataEmpJobUpsert.class,
						SFODataEmpJobRelationshipsUpsert.class,
						SFODataFOJobCodeUpsert.class,
						SFODataPaymentInformationV3Upsert.class,
						SFODataPaymentInformationDetailV3Upsert.class,
						SFODataPerAddressDEFLTUpsert.class,
						SFODataPerEmailUpsert.class,
						SFODataPerEmergencyContactsUpsert.class,
						SFODataPerGlobalInfoUpsert.class,
						SFODataPerNationalIdUpsert.class,
						SFODataPerPersonUpsert.class,
						SFODataPerPersonalUpsert.class,
						SFODataPerPhoneUpsert.class,
						SFODataPhotoUpsert.class,
						SFODataPositionUpsert.class,
						SFODataUserUpsert.class));
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

	private static class UpsertEntitySerializer<T> extends StdSerializer<T> {
		private static final long serialVersionUID = 1L;

		@Override
		public void serialize(T entity, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(entity.getClass());
			BeanDescription beanDesc = provider.getConfig().introspect(javaType);
			JsonSerializer<Object> serializer = BeanSerializerFactory.instance.findBeanOrAddOnSerializer(provider,
					javaType, beanDesc, true);
			generator.writeStartObject();
			generator.writeFieldName("__metadata");
			generator.writeStartObject();
			generator.writeStringField("uri", getMetadataUriFromEntity(entity));
			generator.writeEndObject();
			resetMetadataURIValue(entity);
			serializer.unwrappingSerializer(null).serialize(entity, generator, provider);
			generator.writeEndObject();
		}

		public UpsertEntitySerializer(Class<T> t) {
			super(t);
		}
	}

	private static void resetMetadataURIValue(Object object) {
		try {
			BeanUtils.setProperty(object, "metadataUri", null);
		} catch (IllegalAccessException | InvocationTargetException e) {
			Ivy.log().error(e.getMessage());
		}

	}

	private static String getMetadataUriFromEntity(Object object) {
		try {
			return BeanUtils.getSimpleProperty(object, "metadataUri");
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			Ivy.log().error(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setUpCustomSerializer(List<Class<? extends Object>> list) {
		for (Class objectClass : list) {
			addSerializer(objectClass, new UpsertEntitySerializer(objectClass));
		}
	}
}
