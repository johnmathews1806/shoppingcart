package com.jm.shoppingcart.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.Product;
import com.jm.shoppingcart.entities.User;

@Service
public class ProductService {
	
	public List<Product> getProducts(){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		Session session=factory.openSession();  
		Transaction t=session.beginTransaction();  

		Query query= session.createQuery("FROM Product");	
		
		List prod =query.list();
		
		t.commit();  
		session.close();  
		
		return prod;
	}

}
