package com.jm.shoppingcart.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.Service;

import com.jm.cms.webservices.Country;
import com.jm.cms.webservices.CountryService;
import com.jm.cms.webservices.Product;


public class TestClient {
	@WebServiceRef(wsdlLocation = 
			"http://localhost:7001/utilityservices/hello?wsdl")
	private static CountryService service;

	/**
	 * @param args the command line arguments
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {

		URL url1 = new URL("http://localhost:7001/cmsadministrator/cms/country?wsdl");  
		URL url2 = new URL("http://localhost:7001/cmsadministrator/cms/product?wsdl");

		//1st argument service URI, refer to wsdl document above  
		//2nd argument is service name, refer to wsdl document above  
		QName qname1 = new QName("http://webservices.cms.jm.com/", "CountryService");  
		QName qname2 = new QName("http://webservices.cms.jm.com/", "ProductService");
		Service service1 = Service.create(url1, qname1);
		Service service2 = Service.create(url2, qname2);
		Country c = service1.getPort(Country.class);
		Product p = service2.getPort(Product.class);
		
        System.out.println(c.getCountries());
        System.out.println(p.getProducts().get(0).getProductName());
		//System.out.println(sayHello("world"));
	}

	private static List<String> getCountries() {
		com.jm.cms.webservices.Country port = service.getCountryPort();
		return port.getCountries();
	}
}