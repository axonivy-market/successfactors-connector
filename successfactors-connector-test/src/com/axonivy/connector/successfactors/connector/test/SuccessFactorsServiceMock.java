package com.axonivy.connector.successfactors.connector.test;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Hidden;

@Path("successfactorsMock")
@PermitAll
@Hidden
public class SuccessFactorsServiceMock extends AbstractServiceMock {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("FOBusinessUnit")
	public Response getBusinessUnits(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/businessUnits.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("FODivision")
	public Response getDivisions(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/divisions.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("FODepartment")
	public Response getDepartments(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/departments.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("FOCostCenter")
	public Response getCostcenters(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/costCenters.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("FOLocation")
	public Response getLocations(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/locations.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("EmpJob")
	public Response getJobs(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/costCenters.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("PerPerson")
	public Response getPersons(
			@QueryParam(value = "$filter") String filter,
			@QueryParam(value = "$top") Integer top,
			@QueryParam(value = "$skip") Integer skip,
			@QueryParam(value = "$expand") List<String> expand,
			@QueryParam(value = "$select") List<String> select,
			@QueryParam(value = "$orderby") List<String> orderby,
			@QueryParam(value = "$count") Boolean count) {
		return Response.ok(load("json/costCenters.json")).type(MediaType.APPLICATION_JSON).build();
	}
	
}
