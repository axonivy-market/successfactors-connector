package com.axonivy.connector.successfactors.conncetor.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.axonivy.connector.successfactors.connector.rest.SFODataFOLocation;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.scripting.objects.List;

/**
 * This sample ProcessTest simulates users and systems working through
 * your process flow. Created data and tasks can be easily asserted.
 * 
 * <p>The test can either be run<ul>
 * <li>in the Designer IDE ( <code>right click > run as > JUnit Test </code> )</li>
 * <li>or in a Maven continuous integration build pipeline ( <code>mvn clean verify</code> )</li>
 * </ul></p>
 * 
 * <p>Detailed guidance on writing these kind of tests can be found in our
 * <a href="https://developer.axonivy.com/doc/10.0/concepts/testing/process-testing.html">Process Testing docs</a>
 * </p>
 */
@IvyProcessTest(enableWebServer = true)
public class LocationProcessTest extends AbstractSuccessFactorsTest<SFODataFOLocation> {

	private static final BpmElement getLocationTestee = BpmProcess.path("connector/Location").elementName("getLocations");

	@Override
	protected BpmElement getTestee() {
		return getLocationTestee;
	}

	@Test
	public void getDepartmentTop(BpmClient bpmClient, AppFixture fixture) {
		ExecutionResult result = bpmClient.start().subProcess(getTestee()).withParam("top", 5).execute();
		List<SFODataFOLocation> entities = result.subResult().firstParam();
		assertThat(entities.size()).isGreaterThan(0);
		assertThat(entities.size()).isLessThanOrEqualTo(5);
	}
	
	@Test
	public void getDepartmentSelect(BpmClient bpmClient, AppFixture fixture) {
		List<String> selectValues = List.create(String.class);
		selectValues.add("externalCode");
		selectValues.add("name");

		ExecutionResult result = bpmClient.start().subProcess(getTestee())
				.withParam("select", selectValues).execute();
		List<SFODataFOLocation> entities = result.subResult().firstParam();
		assertThat(entities.size()).isGreaterThan(0);
		assertThat(entities.get(0).getName()).isNotBlank();
		assertThat(entities.get(0).getExternalCode()).isNotBlank();
	}

}
