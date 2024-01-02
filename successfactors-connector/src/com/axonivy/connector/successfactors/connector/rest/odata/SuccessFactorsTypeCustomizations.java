package com.axonivy.connector.successfactors.connector.rest.odata;

import java.io.IOException;

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
		addSerializer(SFODataUserUpsert.class, new UserUpsertSerializer());
		addSerializer(SFODataPerEmailUpsert.class, new EmailUpsertSerializer());
		addSerializer(SFODataPerEmergencyContactsUpsert.class, new EmergencyContactsUpsertSerializer());
		addSerializer(SFODataEmpEmploymentUpsert.class, new EmploymentUpsertSerializer());
		addSerializer(SFODataEmpJobUpsert.class, new JobUpsertSerializer());
		addSerializer(SFODataPerNationalIdUpsert.class, new NationalIdUpsertSerializer());
		addSerializer(SFODataPaymentInformationDetailV3Upsert.class, new PaymentInformationDetailV3UpsertSerializer());
		addSerializer(SFODataPerPersonalUpsert.class, new PersonalUpsertSerializer());
		addSerializer(SFODataPerPersonUpsert.class, new PersonUpsertSerializer());
		addSerializer(SFODataPerPhoneUpsert.class, new PhoneUpsertSerializer());
		addSerializer(SFODataPhotoUpsert.class, new PhotoUpsertSerializer());
		addSerializer(SFODataPerAddressDEFLTUpsert.class, new AddressUpsertSerializer());
		addSerializer(SFODataPaymentInformationV3Upsert.class, new PaymentInformationV3Serializer());
		addSerializer(SFODataEmpJobRelationshipsUpsert.class, new JobRelationshipSerializer());
		addSerializer(SFODataCustEMEAHRdataUpsert.class, new CustAMEAHRDataSerializer());

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

	private static class UserUpsertSerializer extends StdSerializer<SFODataUserUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataUserUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataUserUpsert.class);
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

		public UserUpsertSerializer() {
			super(SFODataUserUpsert.class);
		}
	}

	private static class EmailUpsertSerializer extends StdSerializer<SFODataPerEmailUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerEmailUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPerEmailUpsert.class);
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

		public EmailUpsertSerializer() {
			super(SFODataPerEmailUpsert.class);
		}
	}

	private static class EmergencyContactsUpsertSerializer extends StdSerializer<SFODataPerEmergencyContactsUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerEmergencyContactsUpsert value, JsonGenerator generator,
				SerializerProvider provider) throws IOException {
			JavaType javaType = provider.constructType(SFODataPerEmergencyContactsUpsert.class);
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

		public EmergencyContactsUpsertSerializer() {
			super(SFODataPerEmergencyContactsUpsert.class);
		}
	}

	private static class EmploymentUpsertSerializer extends StdSerializer<SFODataEmpEmploymentUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataEmpEmploymentUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataEmpEmploymentUpsert.class);
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

		public EmploymentUpsertSerializer() {
			super(SFODataEmpEmploymentUpsert.class);
		}
	}

	private static class JobUpsertSerializer extends StdSerializer<SFODataEmpJobUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataEmpJobUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataEmpJobUpsert.class);
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

		public JobUpsertSerializer() {
			super(SFODataEmpJobUpsert.class);
		}
	}

	private static class NationalIdUpsertSerializer extends StdSerializer<SFODataPerNationalIdUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerNationalIdUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPerNationalIdUpsert.class);
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

		public NationalIdUpsertSerializer() {
			super(SFODataPerNationalIdUpsert.class);
		}
	}

	private static class PaymentInformationDetailV3UpsertSerializer
			extends StdSerializer<SFODataPaymentInformationDetailV3Upsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPaymentInformationDetailV3Upsert value, JsonGenerator generator,
				SerializerProvider provider) throws IOException {
			JavaType javaType = provider.constructType(SFODataPaymentInformationDetailV3Upsert.class);
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

		public PaymentInformationDetailV3UpsertSerializer() {
			super(SFODataPaymentInformationDetailV3Upsert.class);
		}
	}

	private static class PersonalUpsertSerializer extends StdSerializer<SFODataPerPersonalUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerPersonalUpsert value, JsonGenerator generator,
				SerializerProvider provider) throws IOException {
			JavaType javaType = provider.constructType(SFODataPerPersonalUpsert.class);
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

		public PersonalUpsertSerializer() {
			super(SFODataPerPersonalUpsert.class);
		}
	}

	private static class PersonUpsertSerializer extends StdSerializer<SFODataPerPersonUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerPersonUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPerPersonUpsert.class);
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

		public PersonUpsertSerializer() {
			super(SFODataPerPersonUpsert.class);
		}
	}

	private static class PhoneUpsertSerializer extends StdSerializer<SFODataPerPhoneUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerPhoneUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPerPhoneUpsert.class);
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

		public PhoneUpsertSerializer() {
			super(SFODataPerPhoneUpsert.class);
		}
	}

	private static class PhotoUpsertSerializer extends StdSerializer<SFODataPhotoUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPhotoUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPhotoUpsert.class);
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

		public PhotoUpsertSerializer() {
			super(SFODataPhotoUpsert.class);
		}
	}

	private static class AddressUpsertSerializer extends StdSerializer<SFODataPerAddressDEFLTUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPerAddressDEFLTUpsert value, JsonGenerator generator, SerializerProvider provider)
				throws IOException {
			JavaType javaType = provider.constructType(SFODataPerAddressDEFLTUpsert.class);
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

		public AddressUpsertSerializer() {
			super(SFODataPerAddressDEFLTUpsert.class);
		}
	}

	private static class PaymentInformationV3Serializer extends StdSerializer<SFODataPaymentInformationV3Upsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataPaymentInformationV3Upsert value, JsonGenerator generator,
				SerializerProvider provider) throws IOException {
			JavaType javaType = provider.constructType(SFODataPaymentInformationV3Upsert.class);
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

		public PaymentInformationV3Serializer() {
			super(SFODataPaymentInformationV3Upsert.class);
		}
	}

	private static class CustAMEAHRDataSerializer extends StdSerializer<SFODataCustEMEAHRdataUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataCustEMEAHRdataUpsert value, JsonGenerator generator,
				SerializerProvider provider) throws IOException {
			JavaType javaType = provider.constructType(SFODataPaymentInformationV3Upsert.class);
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

		public CustAMEAHRDataSerializer() {
			super(SFODataCustEMEAHRdataUpsert.class);
		}
	}

	private static class JobRelationshipSerializer extends StdSerializer<SFODataEmpJobRelationshipsUpsert> {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("deprecation")
		@Override
		public void serialize(SFODataEmpJobRelationshipsUpsert value, JsonGenerator generator,
				SerializerProvider provider) throws IOException {
			JavaType javaType = provider.constructType(SFODataPaymentInformationV3Upsert.class);
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

		public JobRelationshipSerializer() {
			super(SFODataEmpJobRelationshipsUpsert.class);
		}
	}
}
