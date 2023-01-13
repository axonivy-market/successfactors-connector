package com.axonivy.connector.successfactors.connector.rest;


import java.io.IOException;
import java.net.URI;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;

import ch.ivyteam.ivy.environment.Ivy;


public class SucessFactorsQueryStringFilter implements ClientRequestFilter {

	private static final String[] PARAMS_TO_REPLACE = {"$filter"};
	private static final String SUBSTRING_START_CHAR = "=";
	private static final String SUBSTRING_END_CHAR = "&";
	private static final String CHARS_TO_REPLACE = "[\\+]";
	
	@Override
	public void filter(ClientRequestContext context) throws IOException {
		URI uri = context.getUri();
		String queryParam = uri.getQuery();
		
		UriBuilder uriBuilder = UriBuilder.fromUri(uri);
		
//		for(String param : PARAMS_TO_REPLACE) {
//			String value = retrieveParam(queryParam, param);
//			if(StringUtils.isNotBlank(value)) {
//				Ivy.log().info("original param {0}: {1}", param, value);
//				value = value.replaceAll(CHARS_TO_REPLACE, "%20");
//				Ivy.log().info("modified param {0}: {1}", param, value);
//				uriBuilder = uriBuilder.replaceQueryParam(param, value);
//			}
//		}
		
		context.setUri(uriBuilder.queryParam("$format", "json").build());
	}
	
	private String retrieveParam(String query, String param) {
		String result = StringUtils.substringBetween(query, param + SUBSTRING_START_CHAR, SUBSTRING_END_CHAR);
		if(StringUtils.isBlank(result)) {
			result = StringUtils.substringAfter(query, param + SUBSTRING_START_CHAR);
		}
		return result;
	}

}
