package com.uyen.webservices.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@SuppressWarnings("restriction")
@WebService
public class HelloWorld{
 
	@WebMethod(operationName="getHelloWorld")
	public String getHelloWorld(String name) {
		return "Uyennnn Hello World JAX-WS in Tomcat: " + name;
	}
 
}