package com.axonivy.connector.successfactors.connector.rest.odata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ch.ivyteam.text.json.JsonNodeVisitor;

/**
 * This helper class removes the unnecessary nested result attributes in arrays that
 * is provided by Odata V2, so the resulting JSON can be parsed to OpenAPI classes.
 * 
 * <pre>{@code
 * Example (the "results" attribute and its whole tier is removed and 
 * the array moved to the parent attribute "emailNav"): 
 * "emailNav": {
 * 	"results": [
 * 	  {
 * 		"emailType": "127606",
 * 		"emailAddress": "john.doe@test.com",
 * 	  }]
 * }
 * }</pre>
 * @author jpl
 *
 */
public class InnerListResolveVisitor extends JsonNodeVisitor {
	
	private static final String RESULTS = "results";

	protected void removeInnerObject(ObjectNode parent, String fieldName, JsonNode node) {
		if(node.has(RESULTS)) {
			JsonNode resultsNode = node.get(RESULTS);
			parent.remove(fieldName);
			parent.set(fieldName, resultsNode);
		}
	}
	
	@Override
	protected void visitObjectNode(ObjectNode containerObject) {
		List<String> fieldNames = new ArrayList<>();
		for (Iterator<String> it = containerObject.fieldNames(); it.hasNext();) {
			String fieldName = it.next();
			JsonNode node = containerObject.get(fieldName);
			if(node.has(RESULTS)) {
				fieldNames.add(fieldName);
			}
		}
		for(Iterator<String> it = fieldNames.iterator(); it.hasNext();) {
			String fieldName = it.next();
			JsonNode node = containerObject.get(fieldName);
			removeInnerObject(containerObject, fieldName, node);
		}
		super.visitObjectNode(containerObject);
	}
	
}
