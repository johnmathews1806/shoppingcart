package com.jm.shoppingcart.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.User;

@Service
public class OrderService {

	public Collection getOrderbyUser(User user){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  

		Collection<Order> orders = user.getOrders();

		t.commit();  
		session.close();  
		
		return orders;
	}
	
	public void createOrder(User user, List<OrderDetail> orderDetails){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  

		Order newOrder = new Order();
		newOrder.setUser(user);		
		session.persist(newOrder);
		Iterator i = orderDetails.iterator();
		while(i.hasNext()){
			OrderDetail detail = (OrderDetail)i.next();
			detail.setOrder(newOrder);
			session.persist(detail);
		}

		t.commit();  
		session.close();  
		
		
	}

}
