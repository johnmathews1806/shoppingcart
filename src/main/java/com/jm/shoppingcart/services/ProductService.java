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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.Product;
import com.jm.shoppingcart.entities.User;

@Service

public class ProductService {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Transactional
	public List<Product> getProducts(){
		Session session=sessionFactory.getCurrentSession();

		Query query= session.createQuery("FROM Product");	
		
		List prod =query.list();  
		
		return prod;
	}
	
	@Transactional
	public Product getProduct(int productId){
		Session session=sessionFactory.getCurrentSession();

		Query query= session.createQuery("FROM Product p where p.productId=:productId");
		query.setParameter("productId", productId);
		
		Product prod =(Product)query.uniqueResult();	  
		
		return prod;
	}

}
