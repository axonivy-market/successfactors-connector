package com.axonivy.connector.successfactors.conncetor.test;

import com.axonivy.connector.successfactors.connector.rest.SFODataFODepartment;

import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;

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
@IvyProcessTest
public class DepartmentProcessTest extends AbstractFoObjectTest<SFODataFODepartment> {

	private static final BpmElement getDeparmentTestee = BpmProcess.path("connector/Department").elementName("getDepartments");

//	@Override
//	protected Class<SFODataFODepartment> getType() {
//		return SFODataFODepartment.class;
//	}
	
	@Override
	protected BpmElement getTestee() {
		return getDeparmentTestee;
	}

	@Override
	protected String getName(SFODataFODepartment entity) {
		return entity.getName();
	}

	@Override
	protected String getExternalCode(SFODataFODepartment entity) {
		return entity.getExternalCode();
	}

	@Override
	protected String getStatusValue(SFODataFODepartment entity) {
		return entity.getStatusNav().getValue();
	}

	@Override
	protected String getStatusLocalized(SFODataFODepartment entity) {
		return entity.getStatusNav().getLocalized();
	}

}
