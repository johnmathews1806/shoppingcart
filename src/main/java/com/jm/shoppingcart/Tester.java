package com.jm.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.*;  
import org.hibernate.cfg.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.Product;
import com.jm.shoppingcart.entities.User;
import com.jm.shoppingcart.services.OrderService;
import com.jm.shoppingcart.services.ProductService;
import com.jm.shoppingcart.services.UserService;  

public class Tester {


	public String getApplicationName(){
		return "Shopping Cart";
	}

	public static void main(String[] args){
		System.out.println("In Main");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		//When Using hibernate without Spring
/*		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();  

		 Session session=new AnnotationConfiguration()  
		       .configure().buildSessionFactory().openSession();
*/		
		UserService userService = context.getBean(UserService.class);
		//UserService service = new UserService();
		ProductService prodService = context.getBean(ProductService.class);
		OrderService orderService = context.getBean(OrderService.class);
		
		Tester tester = new Tester();
		Iterator i = prodService.getProducts().iterator();
		while(i.hasNext()){
			System.out.println(((Product)i.next()).getProductName());			
		}
				
		tester.insertData(userService,prodService,orderService);

		System.out.println("Invoking service..");
		System.out.println("User details: "+userService.getUserbyLogin("jmjohn", "asdfsadf"));
		Iterator m= userService.searchUserByName("John","X","Mathews").iterator();
		while(m.hasNext()){
			//System.out.println(((Product)m.next()).getProductName());	
			System.out.println(((User)m.next()).getLoginId());
		}

		//t.commit();  
		//session.close();  
		System.out.println("successfully executed");  

		/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "shoppingcart" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );

		User user = entitymanager.find( User.class, 2 );
		entitymanager.remove( user );
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
		 */
		context.close();
	}

	public void insertData(UserService userService,ProductService prodService,OrderService orderService){
		/*User user1=new User();  
		user1.setFirstName("John");
		user1.setMiddleName(" ");  
		user1.setLastName("Mathews");		
		user1.setLoginId("jmjohn");
		user1.setPassword("asdfsadf");
		user1.setCreateDate(new Date());
		user1.setDob(new Date());

		session.persist(user1); */

	/*	Product prod = new Product();
		prod.setProductName("Samsung Galaxy");
		prod.setDescription("Smart Phone");
		prod.setPrice(new BigDecimal("65000"));
		prod.setCreateDate(new Date());
		prod.setCreateuser("ADMIN");
		prod.setUpdateDate(new Date());
		prod.setUpdateUser("ADMIN");

		session.persist(prod);		
*/		
		User user2 = userService.getUserbyLoginId("jmjohn1");

		/*ContactDetail ctd = new ContactDetail();
		//ctd.setUserId(1);
		ctd.setUser(user2);
		ctd.setAddress1("Address Line1");
		ctd.setAddress2("Address Line2");
		ctd.setCity("Bangalore");
		ctd.setCountry("India");
		ctd.setEmailId("jm.john@gmail.com");
		ctd.setPhone("80 49184562");
		ctd.setMobile("80 49184562");
		ctd.setCreateDate(new Date());
		ctd.setCreateuser("ADMIN");
		ctd.setUpdateDate(new Date());
		ctd.setUpdateUser("ADMIN");

		user2.getContactDetails().add(ctd);

		session.persist(ctd); */

		/*System.out.println(user2);
		System.out.println(user2.getFirstName());
		Collection<ContactDetail> contacts = user2.getContactDetails();

		Iterator i = contacts.iterator();
		while(i.hasNext()){
			System.out.println(((ContactDetail)i.next()).getAddress1());
		}	 */
		
/*		Collection<Order> orders = orderService.getOrderbyUser(user2);

		Iterator j = orders.iterator();
		while(j.hasNext()){
			Collection<OrderDetail> details = ((Order)j.next()).getOrderDetails();
			Iterator k =  details.iterator();
			while(k.hasNext()){
				System.out.println(((OrderDetail)k.next()).getAmount());	
			}		    	
		}*/

		
		Product prod1 = prodService.getProducts().get(0);
		Product prod2 = prodService.getProducts().get(1);

				List<OrderDetail> orders = new ArrayList<OrderDetail>();
				OrderDetail ordDetails1 = new OrderDetail();			    
				ordDetails1.setProduct(prod1);
				ordDetails1.setQuantity(3);
				ordDetails1.setAmount(new BigDecimal(120000));

				OrderDetail ordDetails2 = new OrderDetail();			    
				ordDetails2.setProduct(prod2);
				ordDetails2.setQuantity(3);
				ordDetails2.setAmount(new BigDecimal(165000));

				orders.add(ordDetails1);
				orders.add(ordDetails2);

				orderService.createOrder(user2, orders);

	}
}
