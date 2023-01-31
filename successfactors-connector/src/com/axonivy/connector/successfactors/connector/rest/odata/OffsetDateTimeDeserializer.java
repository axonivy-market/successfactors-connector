package com.axonivy.connector.successfactors.connector.rest.odata;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


/**
 * This class handles SuccessFactors' specific date format.
 * <br/><br/>
 * Format:<br/>
 * /Date(1503655540000+0000)/
 */
public class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

	@Override
	public OffsetDateTime deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JacksonException {
		
		JsonNode node = parser.readValueAsTree();
		return extractDate(node);
	}

	/* Format of date is 
	 * /Date(-2208988800000)/
	 * /Date(1546848502000+0000)/
	 */
	private OffsetDateTime extractDate(JsonNode node) {
		OffsetDateTime result = null;
		if(Objects.nonNull(node)) {
			String dateString = node.asText();
			String epochString = StringUtils.substringBetween(dateString, "/Date(", ")/");
			epochString = StringUtils.substringBefore(epochString, "+");
			if(StringUtils.isNotBlank(epochString)) {
				result = OffsetDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(epochString)), ZoneId.systemDefault());
			}
		}
		return result;
	}
	  
  }