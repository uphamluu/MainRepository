package com.phamluu.Webservice.documentstyle.server;
import javax.xml.ws.Endpoint;
//Endpoint publisher
public class HelloWorldPublisherDocument{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:7779/ws/hello", new HelloWorldImpl());
    }
 
}