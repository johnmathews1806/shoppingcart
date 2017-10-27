package com.jm.shoppingcart.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.Product;
import com.jm.shoppingcart.entities.User;

@Service
public class OrderService {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Transactional
	public List<Order> getOrderbyUser(User user){
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();  	
		//Transaction t=session.beginTransaction();
		Session session=sessionFactory.getCurrentSession();
		
		//Collection<Order> orders = user.getOrders();
		Query query= session.createQuery("FROM Order o where o.user=:user");
		query.setParameter("user", user);
		
		List<Order> orders =query.list();

		//t.commit();  
		//session.close();  
		
		return orders;
	}
	
	@Transactional
	public int createOrder(User user  , List<OrderDetail> orderDetails){
		int status = 1;
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();  
		//Transaction t=session.beginTransaction();  
		Session session=sessionFactory.getCurrentSession();		
		
		Order newOrder = new Order();
		newOrder.setUser(user);		
		session.persist(newOrder);
		Iterator i = orderDetails.iterator();
		while(i.hasNext()){
			OrderDetail detail = (OrderDetail)i.next();
			detail.setOrder(newOrder);
			session.persist(detail);
			status = 0;
		}
		return status;
//		t.commit();  
	//	session.close();  
		
		
	}

}
