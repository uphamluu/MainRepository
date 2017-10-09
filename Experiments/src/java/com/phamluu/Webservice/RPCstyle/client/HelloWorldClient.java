package com.phamluu.Webservice.RPCstyle.client;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.phamluu.Webservice.RPCstyle.HelloWorld;

 
public class HelloWorldClient{
 	public static void main(String[] args) throws Exception {
 	URL url = new URL("http://localhost:7779/ws/hello?wsdl");
 
        //1st argument service URI, refer to wsdl document above
	    //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://server.RPCstyle.Webservice.phamluu.com/", "HelloWorldImplService");
 
        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);
        String result = hello.getHelloWorldAsString("call from client");
        long time = System.currentTimeMillis();
        result = result+ " result at :" +time;
        System.out.println(result);
 
    }
 
}