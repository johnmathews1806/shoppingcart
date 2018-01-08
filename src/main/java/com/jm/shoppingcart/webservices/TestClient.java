package com.jm.shoppingcart.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.Service;

import com.jm.utilityservices.webservices.Hello;
import com.jm.utilityservices.webservices.HelloService;


public class TestClient {
	@WebServiceRef(wsdlLocation = 
			"http://localhost:7001/utilityservices/hello?wsdl")
	private static HelloService service;

	/**
	 * @param args the command line arguments
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://localhost:7001/utilityservices/hello?wsdl");  

		//1st argument service URI, refer to wsdl document above  
		//2nd argument is service name, refer to wsdl document above  
		QName qname = new QName("http://webservices.utilityservices.jm.com/", "HelloService");  
		Service service = Service.create(url, qname);
		Hello hello = service.getPort(Hello.class);  
        System.out.println(hello.sayHello("document style")); 
		//System.out.println(sayHello("world"));
	}

	private static String sayHello(java.lang.String arg0) {
		com.jm.utilityservices.webservices.Hello port = service.getHelloPort();
		return port.sayHello(arg0);
	}
}