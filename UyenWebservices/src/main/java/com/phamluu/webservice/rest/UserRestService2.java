package com.phamluu.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users2")
// vidu : 
public class UserRestService2 {

	@GET
	@Path("{year}/{month}/{day}")
	
	//vi du: http://localhost:8080/ws/users2/2011/06/30 --> nhan duoc: 
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month,
			@PathParam("day") int day) {

	   String dateInString = year + "/" + month + "/" + day;

	   return Response.status(200)
		.entity("getUserHistory is called, year/month/day : " + dateInString)
		.build();

	}

}