
package com.uyen.webservices.soa.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.uyen.webservices.soa.HelloWorld;



public class FirstSimpleSOAClient {

	public static void main(String[] args) throws MalformedURLException {
		System.err.println("Uyen");
		
		URL url = new URL("http://localhost:8080/ws/hello?wsdl");
		 
        //1st argument service URI, refer to wsdl document above
	    //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soa.webservices.uyen.com/", "HelloWorldService");
 
        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);
 
        System.out.println(hello.getHelloWorld("Uyen first consummer"));
		

	}

}
