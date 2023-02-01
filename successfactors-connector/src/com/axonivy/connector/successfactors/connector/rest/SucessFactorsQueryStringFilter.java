package com.axonivy.connector.successfactors.connector.rest;


import java.io.IOException;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.UriBuilder;

/**
 * Handle SuccessFactors query & path parameter specifics.
 * 
 * @author jpl
 *
 */
public class SucessFactorsQueryStringFilter implements ClientRequestFilter {

	private static final Pattern EFFECTIVE_DATE_PATTERN = Pattern.compile("(effectiveStartDate=)(\\S+)\\.([0-9:\\+]+)");
	
	@Override
	public void filter(ClientRequestContext context) throws IOException {
		URI uri = context.getUri();
		
		// replace format for effective date path parameter
		String path = uri.getPath();		
		Matcher matcher = EFFECTIVE_DATE_PATTERN.matcher(path);
		UriBuilder uriBuilder = UriBuilder.fromUri(uri);
		uriBuilder.replacePath(matcher.replaceAll("$1datetime'$2'"));
		
		context.setUri(uriBuilder.queryParam("$format", "json").build());
	}
	
}
