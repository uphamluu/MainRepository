package com.phamluu.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
//vi du: http://localhost:8080/ws/users --> nhan duoc: "http://localhost:8080/users"
public class UserRestService1 {

	@GET
	public Response getUser() {

		return Response.status(200).entity("getUser is called").build();

	}

	@GET
	@Path("/vip")
	//vi du: http://localhost:8080/ws/users/vip --> nhan duoc: "getUserVIP is called"
	public Response getUserVIP() {

		return Response.status(200).entity("getUserVIP is called").build();

	}

	@GET
	@Path("{name}")
	//vi du:  http://localhost:8080/ws/users/mkyong --> nhan duoc: "getUserByName is called, name : mkyong"
	public Response getUserByName(@PathParam("name") String name) {

		return Response.status(200)
				.entity("getUserByName is called, name : " + name).build();

	}

	@GET
	@Path("{id : \\d+}")
	//vi du:  http://localhost:8080/ws/users/999 --> getUserById is called, id : 999
	public Response getUserById(@PathParam("id") String id) {

		return Response.status(200).entity("getUserById is called, id : " + id)
				.build();

	}

	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	//	vi du: http://localhost:8080/ws/users/username/a9 --> getUserById is called, id : 999
	
	public Response getUserByUserName(@PathParam("username") String username) {

		return Response.status(200)
				.entity("getUserByUserName is called, username : " + username)
				.build();

	}

	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

		return Response.status(200)
				.entity("getUserBookByISBN is called, isbn : " + isbn).build();

	}

}