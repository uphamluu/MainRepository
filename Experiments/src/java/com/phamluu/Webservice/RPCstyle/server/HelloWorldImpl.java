package com.phamluu.Webservice.RPCstyle.server;

import javax.jws.WebService;

import com.phamluu.Webservice.RPCstyle.HelloWorld;

//Service Implementation
@WebService(endpointInterface = "com.phamluu.Webservice.RPCstyle.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString(String name) {
		long time = System.currentTimeMillis();
		String result = "incoming: "+ name +" at: "+ time;
		return result;
	}

}