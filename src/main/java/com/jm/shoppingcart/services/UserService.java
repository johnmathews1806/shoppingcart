package com.jm.shoppingcart.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.User;

@Service
public class UserService {
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public List<User> searchUserByName(String firstName, String middleName, String lastName){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		Session session=factory.openSession();
		System.out.println("Obtained factory: "+sessionFactory);
		//Session session=sessionFactory.openSession();
		System.out.println("Obtained session: "+session);
		Transaction t=session.beginTransaction();
		System.out.println("Obtained transaction: "+t);
		Criteria c = session.createCriteria(User.class);
		if(firstName != null) c.add(Restrictions.ilike("firstName", firstName,MatchMode.ANYWHERE));
		if(middleName != null) c.add(Restrictions.ilike("middleName", middleName,MatchMode.ANYWHERE));
		if(lastName != null) c.add(Restrictions.ilike("lastName", lastName,MatchMode.ANYWHERE));			
		
		List user =c.list();
		
		t.commit();  
		session.close();  
		
		return user;
	}

	
	public List<User> getUserByName(String firstName, String middleName, String lastName){
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();  
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();  

		//Query query= session.createQuery("FROM User U where ((:firstName is null and U.firstName is null) or U.firstName = :firstName) and ((:middleName is null and U.middleName is null) or U.middleName = :middleName) and ((:lastName is null and U.lastName is null) or U.lastName = :lastName))");		
		Criteria c = session.createCriteria(User.class);
		c.add(firstName == null ? Restrictions.isNull("firstName") : Restrictions.eq("firstName", firstName));
		c.add(middleName == null ? Restrictions.isNull("middleName") : Restrictions.eq("middleName", middleName));
		c.add(lastName == null ? Restrictions.isNull("lastName") : Restrictions.eq("lastName", lastName));
		//query.setParameter("firstName", firstName);
		//query.setParameter("middleName", null);
		//query.setParameter("lastName", lastName);
		
		List user =c.list();
		
		t.commit();  
		session.close();  
		
		return user;
	}
	
	public User getUserbyLogin(String loginId, String password){
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		Criteria c = session.createCriteria(User.class);
		c.add(loginId == null ? Restrictions.isNull("loginId") : Restrictions.eq("loginId", loginId));
		c.add(password == null ? Restrictions.isNull("password") : Restrictions.eq("password", password));		
		
		User user =(User)c.uniqueResult();
		
		t.commit();  
		session.close();  
		
		return user;
	}

}
