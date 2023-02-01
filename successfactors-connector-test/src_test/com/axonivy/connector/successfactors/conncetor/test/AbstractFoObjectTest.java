package com.axonivy.connector.successfactors.conncetor.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.scripting.objects.List;

public abstract class AbstractFoObjectTest <T extends Object> extends AbstractSuccessFactorsTest<T> {

	@Test
	public void testGetTop(BpmClient bpmClient, AppFixture fixture) {
		ExecutionResult result = bpmClient.start().subProcess(getTestee()).withParam("top", 5).execute();
		List<T> entities = result.subResult().firstParam();
		assertThat(entities.size()).isGreaterThan(0);
		assertThat(entities.size()).isLessThanOrEqualTo(5);
	}
	
	@Test
	public void testGetSelect(BpmClient bpmClient, AppFixture fixture) {
		List<String> selectValues = List.create(String.class);
		selectValues.add("externalCode");
		selectValues.add("name");

		ExecutionResult result = bpmClient.start().subProcess(getTestee())
				.withParam("select", selectValues).execute();
		List<T> entities = result.subResult().firstParam();
		assertThat(entities.size()).isGreaterThan(0);
		assertThat(getName(entities.get(0))).isNotBlank();
		assertThat(getExternalCode(entities.get(0))).isNotBlank();
	}
	
	@Test
	public void testGetExpand(BpmClient bpmClient, AppFixture fixture) {

		List<String> selectValues = List.create(String.class);
		selectValues.add("externalCode");
		selectValues.add("statusNav/value");
		selectValues.add("statusNav/localized");

		List<String> expandValues = List.create(String.class);
		expandValues.add("statusNav");

		ExecutionResult result = bpmClient.start().subProcess(getTestee())
				.withParam("select", selectValues)
				.withParam("expand", expandValues)
				.execute();
		List<T> entities = result.subResult().firstParam();
		assertThat(entities.size()).isGreaterThan(0);
		assertThat(getStatusValue(entities.get(0))).isNotBlank();
		assertThat(getStatusValue(entities.get(0))).isNotBlank();
	}
	
	protected abstract String getName(T entity);
	protected abstract String getExternalCode(T entity);
	protected abstract String getStatusValue(T entity);
	protected abstract String getStatusLocalized(T entity);
}
