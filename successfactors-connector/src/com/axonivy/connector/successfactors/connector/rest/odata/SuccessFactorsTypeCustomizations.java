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
//		addDeserializer(AnyOfSFODataEmpJobSeqNumber.class, new SquNumberDeserializer());
//		addDeserializer(AnyOfSFODataPerPersonPersonId.class, new PerPersonIdDeserializer());
//		addDeserializer(AnyOfSFODataPositionTargetFTE.class, new PositionTargetFTEDeserializer());
//		addDeserializer(AnyOfSFODataPositionTransactionSequence.class, new AnyOfSFODataPositionTransactionSequenceDeserializer());
//		addDeserializer(AnyOfSFODataPicklistOptionId.class, new PicklistOptionIdDeserializer());
//		addDeserializer(AnyOfSFODataCustRoletypesExternalCode.class, new CustRoletypesExternalCodeDeserializer());
//		addDeserializer(AnyOfSFODataCustRoletypesCustUtilisation.class, new CustRoletypesCustUtilisationDeserializer());
//		addDeserializer(AnyOfSFODataPickListValueV2LegacyStatus.class, new PickListValueV2LegacyStatusDeserializer());
//		addDeserializer(AnyOfSFODataPickListValueV2OptionId.class, new PickListValueV2OptionIdDeserializer());
//		addDeserializer(AnyOfSFODataUserTotalTeamSize.class, new UserTotalTeamSizeDeserializer());
//		addDeserializer(AnyOfSFODataPicklistLabelOptionId.class, new PicklistLabelOptionIdDeserializer());
//		addDeserializer(AnyOfSFODataPicklistLabelId.class, new PicklistLabelIdDeserializer());
//		addDeserializer(AnyOfSFODataPositionStandardHours.class, new PositionStandardHoursDeserializer());
//		addDeserializer(AnyOfSFODataCustEMEAHRdataCustMperc.class, new BonusMaxPercentageDeserializer());
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

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	private void nullify(Class<?> raw) {
//		addDeserializer(raw, new Nullifier(raw));
//	}

//	private static class PickListValueV2OptionIdDeserializer extends StdDeserializer<AnyOfSFODataPickListValueV2OptionId>	{
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public PickListValueV2OptionIdDeserializer() {
//			super(AnyOfSFODataPickListValueV2OptionId.class);
//		}
//
//		@Override
//		public AnyOfSFODataPickListValueV2OptionId deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException	{
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class PickListValueV2LegacyStatusDeserializer extends StdDeserializer<AnyOfSFODataPickListValueV2LegacyStatus>	{
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public PickListValueV2LegacyStatusDeserializer() {
//			super(AnyOfSFODataPickListValueV2LegacyStatus.class);
//		}
//
//		@Override
//		public AnyOfSFODataPickListValueV2LegacyStatus deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException	{
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class CustRoletypesCustUtilisationDeserializer extends StdDeserializer<AnyOfSFODataCustRoletypesCustUtilisation>	{
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public CustRoletypesCustUtilisationDeserializer() {
//			super(AnyOfSFODataCustRoletypesCustUtilisation.class);
//		}
//
//		@Override
//		public AnyOfSFODataCustRoletypesCustUtilisation deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException	{
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class CustRoletypesExternalCodeDeserializer extends StdDeserializer<AnyOfSFODataCustRoletypesExternalCode>	{
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public CustRoletypesExternalCodeDeserializer() {
//			super(AnyOfSFODataCustRoletypesExternalCode.class);
//		}
//
//		@Override
//		public AnyOfSFODataCustRoletypesExternalCode deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException	{
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class SquNumberDeserializer extends StdDeserializer<AnyOfSFODataEmpJobSeqNumber>	{
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public SquNumberDeserializer() {
//			super(AnyOfSFODataEmpJobSeqNumber.class);
//		}
//
//		@Override
//		public AnyOfSFODataEmpJobSeqNumber deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException	{
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class BonusMaxPercentageDeserializer extends StdDeserializer<AnyOfSFODataCustEMEAHRdataCustMperc> {
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public BonusMaxPercentageDeserializer() {
//			super(AnyOfSFODataCustEMEAHRdataCustMperc.class);
//		}
//
//		@Override
//		public AnyOfSFODataCustEMEAHRdataCustMperc deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException {
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class UserTotalTeamSizeDeserializer extends StdDeserializer<AnyOfSFODataUserTotalTeamSize>	{
//		private static final long serialVersionUID = 1l;
//
//		public UserTotalTeamSizeDeserializer() {
//			super(AnyOfSFODataUserTotalTeamSize.class);
//		}
//
//		@Override
//		public AnyOfSFODataUserTotalTeamSize deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException	{
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class PerPersonIdDeserializer extends StdDeserializer<AnyOfSFODataPerPersonPersonId> {
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public PerPersonIdDeserializer() {
//			super(AnyOfSFODataPerPersonPersonId.class);
//		}
//
//		@Override
//		public AnyOfSFODataPerPersonPersonId deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException {
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class PicklistOptionIdDeserializer extends StdDeserializer<AnyOfSFODataPicklistOptionId> {
//		private static final long serialVersionUID = 8173333520337377195L;
//
//		public PicklistOptionIdDeserializer() {
//			super(AnyOfSFODataPicklistOptionId.class);
//		}
//
//		@Override
//		public AnyOfSFODataPicklistOptionId deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JsonProcessingException {
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class AnyOfSFODataPositionTransactionSequenceDeserializer extends StdDeserializer<AnyOfSFODataPositionTransactionSequence> {
//
//		private static final long serialVersionUID = -5347020617311028513L;
//
//		public AnyOfSFODataPositionTransactionSequenceDeserializer() {
//			super(AnyOfSFODataPositionTransactionSequence.class);
//		}
//
//		@Override
//		public AnyOfSFODataPositionTransactionSequence deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JacksonException {
//			return new StringWrapper(p.getText());
//		}
//
//	}
//
//	private static class PositionTargetFTEDeserializer extends StdDeserializer<AnyOfSFODataPositionTargetFTE> {
//
//		private static final long serialVersionUID = -5347020617311028513L;
//
//		public PositionTargetFTEDeserializer() {
//			super(AnyOfSFODataPositionTargetFTE.class);
//		}
//
//		@Override
//		public AnyOfSFODataPositionTargetFTE deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JacksonException {
//			return new StringWrapper(p.getText());
//		}
//
//	}
//
//	private static class PositionStandardHoursDeserializer extends StdDeserializer<AnyOfSFODataPositionStandardHours> {
//		private static final long serialVersionUID = 5111700727479172703L;
//
//		public PositionStandardHoursDeserializer() {
//			super(AnyOfSFODataPositionStandardHours.class);
//		}
//
//		@Override
//		public AnyOfSFODataPositionStandardHours deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JacksonException {
//			return new StringWrapper(p.getText());
//		}
//	}
//
//	private static class PicklistLabelOptionIdDeserializer extends StdDeserializer<AnyOfSFODataPicklistLabelOptionId> {
//		private static final long serialVersionUID = 1l;
//
//		public PicklistLabelOptionIdDeserializer() {
//			super(AnyOfSFODataPicklistLabelOptionId.class);
//		}
//
//		@Override
//		public AnyOfSFODataPicklistLabelOptionId deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JacksonException {
//			return new StringWrapper(p.getText());
//		}
//	}
//	private static class PicklistLabelIdDeserializer extends StdDeserializer<AnyOfSFODataPicklistLabelId> {
//		private static final long serialVersionUID = 1l;
//
//		public PicklistLabelIdDeserializer() {
//			super(AnyOfSFODataPicklistLabelId.class);
//		}
//
//		@Override
//		public AnyOfSFODataPicklistLabelId deserialize(JsonParser p, DeserializationContext ctxt)
//				throws IOException, JacksonException {
//			return new StringWrapper(p.getText());
//		}
//	}

//	private static class StringWrapper implements AnyOfSFODataPositionTargetFTE, 
//		AnyOfSFODataPositionTransactionSequence,
//		AnyOfSFODataPerPersonPersonId,
//		AnyOfSFODataEmpJobSeqNumber,
//		AnyOfSFODataPicklistOptionId, 
//		AnyOfSFODataCustRoletypesExternalCode,
//		AnyOfSFODataCustRoletypesCustUtilisation,
//		AnyOfSFODataPickListValueV2LegacyStatus,
//		AnyOfSFODataPickListValueV2OptionId,
//		AnyOfSFODataUserTotalTeamSize,
//		AnyOfSFODataPicklistLabelOptionId,
//		AnyOfSFODataPicklistLabelId,
//		AnyOfSFODataPositionStandardHours,
//		AnyOfSFODataCustEMEAHRdataCustMperc
//		{
//
//		private final String value;
//
//		public StringWrapper(String value) {
//			this.value = value;
//		}
//
//		@Override
//		public String toString() {
//			return value;
//		}
}
