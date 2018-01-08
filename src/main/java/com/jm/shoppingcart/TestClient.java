package com.jm.shoppingcart;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.Service;

import com.jm.utilityservices.webservices.Country;
import com.jm.utilityservices.webservices.Hello;
import com.jm.utilityservices.webservices.HelloService;


public class TestClient {
	@WebServiceRef(wsdlLocation = 
			"http://localhost:7001/utilityservices/hello?wsdl")
	/**
	 * @param args the command line arguments
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {

		URL urlHello = new URL("http://localhost:7001/utilityservices/hello?wsdl");  

		//1st argument service URI, refer to wsdl document above  
		//2nd argument is service name, refer to wsdl document above  
		QName qnameHello = new QName("http://webservices.utilityservices.jm.com/", "HelloService");  
		Service serviceHello = Service.create(urlHello, qnameHello);
		Hello hello = serviceHello.getPort(Hello.class);  
        System.out.println(hello.sayHello("document style"));

        
        URL urlCountry = new URL("http://localhost:7001/utilityservices/country?wsdl");  

		//1st argument service URI, refer to wsdl document above  
		//2nd argument is service name, refer to wsdl document above  
		QName qnameCountry = new QName("http://webservices.utilityservices.jm.com/", "CountryService");  
		Service serviceCountry = Service.create(urlCountry, qnameCountry);
		Country country = serviceCountry.getPort(Country.class);  
        System.out.println(country.getCountries());		

	}

}