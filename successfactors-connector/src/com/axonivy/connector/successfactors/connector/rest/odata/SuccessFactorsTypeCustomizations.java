package com.axonivy.connector.successfactors.connector.rest.odata;

import java.io.IOException;

import com.axonivy.connector.successfactors.connector.rest.AnyOfSFODataEmpJobSeqNumber;
import com.axonivy.connector.successfactors.connector.rest.AnyOfSFODataPerPersonPersonId;
import com.axonivy.connector.successfactors.connector.rest.AnyOfSFODataPicklistOptionId;
import com.axonivy.connector.successfactors.connector.rest.AnyOfSFODataPositionTargetFTE;
import com.axonivy.connector.successfactors.connector.rest.AnyOfSFODataPositionTransactionSequence;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Some values in the converted SuccessFactors ODATA spec are generated as empty interfaces without a matching impl.
 * 
 * @author jpl
 *
 */
public class SuccessFactorsTypeCustomizations extends SimpleModule {

	private static final long serialVersionUID = 4552540562745977391L;

	public SuccessFactorsTypeCustomizations()
	{
		addDeserializer(AnyOfSFODataEmpJobSeqNumber.class, new SquNumberDeserializer());
		addDeserializer(AnyOfSFODataPerPersonPersonId.class, new PerPersonIdDeserializer());
		addDeserializer(AnyOfSFODataPositionTargetFTE.class, new PositionTargetFTEDeserializer());
		addDeserializer(AnyOfSFODataPositionTransactionSequence.class, new AnyOfSFODataPositionTransactionSequenceDeserializer());
		addDeserializer(AnyOfSFODataPicklistOptionId.class, new PicklistOptionIdDeserializer());
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private void nullify(Class<?> raw) {
		addDeserializer(raw, new Nullifier(raw));
	}

	private static class SquNumberDeserializer extends StdDeserializer<AnyOfSFODataEmpJobSeqNumber>	{
		private static final long serialVersionUID = 8173333520337377195L;

		public SquNumberDeserializer() {
			super(AnyOfSFODataEmpJobSeqNumber.class);
		}

		@Override
		public AnyOfSFODataEmpJobSeqNumber deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException	{
			return new StringWrapper(p.getText());
		}
	}

	private static class PerPersonIdDeserializer extends StdDeserializer<AnyOfSFODataPerPersonPersonId> {
		private static final long serialVersionUID = 8173333520337377195L;

		public PerPersonIdDeserializer() {
			super(AnyOfSFODataPerPersonPersonId.class);
		}

		@Override
		public AnyOfSFODataPerPersonPersonId deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			return new StringWrapper(p.getText());
		}
	}
	
	private static class PicklistOptionIdDeserializer extends StdDeserializer<AnyOfSFODataPicklistOptionId> {
		private static final long serialVersionUID = 8173333520337377195L;

		public PicklistOptionIdDeserializer() {
			super(AnyOfSFODataPicklistOptionId.class);
		}

		@Override
		public AnyOfSFODataPicklistOptionId deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			return new StringWrapper(p.getText());
		}
	}

	private static class AnyOfSFODataPositionTransactionSequenceDeserializer extends StdDeserializer<AnyOfSFODataPositionTransactionSequence> {

		private static final long serialVersionUID = -5347020617311028513L;

		public AnyOfSFODataPositionTransactionSequenceDeserializer() {
			super(AnyOfSFODataPositionTransactionSequence.class);
		}

		@Override
		public AnyOfSFODataPositionTransactionSequence deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JacksonException {
			return new StringWrapper(p.getText());
		}

	}

	private static class PositionTargetFTEDeserializer extends StdDeserializer<AnyOfSFODataPositionTargetFTE> {

		private static final long serialVersionUID = -5347020617311028513L;

		public PositionTargetFTEDeserializer() {
			super(AnyOfSFODataPositionTargetFTE.class);
		}

		@Override
		public AnyOfSFODataPositionTargetFTE deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JacksonException {
			return new StringWrapper(p.getText());
		}

	}

	private static class StringWrapper implements AnyOfSFODataPositionTargetFTE, 
		AnyOfSFODataPositionTransactionSequence,
		AnyOfSFODataPerPersonPersonId,
		AnyOfSFODataEmpJobSeqNumber,
		AnyOfSFODataPicklistOptionId
		{

		private final String value;

		public StringWrapper(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}

	}
	
}
