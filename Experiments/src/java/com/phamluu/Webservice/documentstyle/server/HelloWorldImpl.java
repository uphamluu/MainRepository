package com.phamluu.Webservice.documentstyle.server;

import javax.jws.WebService;

import com.phamluu.Webservice.documentstyle.HelloWorld;

//Service Implementation
@WebService(endpointInterface = "com.phamluu.Webservice.documentstyle.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS(Style.DOCUMENT) " + name;
	}

}