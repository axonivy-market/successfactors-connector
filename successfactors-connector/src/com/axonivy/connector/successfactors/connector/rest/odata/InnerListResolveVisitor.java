package com.axonivy.connector.successfactors.connector.rest.odata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ch.ivyteam.text.json.JsonNodeVisitor;

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
