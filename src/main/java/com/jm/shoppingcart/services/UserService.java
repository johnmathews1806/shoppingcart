package com.jm.shoppingcart.services;

import java.util.Collection;
import java.util.Iterator;
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
import org.springframework.transaction.annotation.Transactional;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.User;


@Service
public class UserService {
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	//like match
	@Transactional
	public List<User> searchUserByName(String firstName, String middleName, String lastName){
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();//to be used when not using @Transactional
		//System.out.println("Obtained factory: "+sessionFactory);
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session1: "+session.toString());
		//Transaction t=session.beginTransaction();
		//System.out.println("Obtained transaction1: "+t);
		Criteria c = session.createCriteria(User.class);
		if(firstName != null) c.add(Restrictions.ilike("firstName", firstName,MatchMode.ANYWHERE));
		if(middleName != null) c.add(Restrictions.ilike("middleName", middleName,MatchMode.ANYWHERE));
		if(lastName != null) c.add(Restrictions.ilike("lastName", lastName,MatchMode.ANYWHERE));			
		
		List user =c.list();
		
		//t.commit();  
		//session.close();  
		
		return user;
	}

	//exact match
	@Transactional
	public List<User> getUserByName(String firstName, String middleName, String lastName){
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session2: "+session.toString());		

		//Query query= session.createQuery("FROM User U where ((:firstName is null and U.firstName is null) or U.firstName = :firstName) and ((:middleName is null and U.middleName is null) or U.middleName = :middleName) and ((:lastName is null and U.lastName is null) or U.lastName = :lastName))");		
		Criteria c = session.createCriteria(User.class);
		c.add(firstName == null ? Restrictions.isNull("firstName") : Restrictions.eq("firstName", firstName.toUpperCase()));
		c.add(middleName == null ? Restrictions.isNull("middleName") : Restrictions.eq("middleName", middleName.toUpperCase()));
		c.add(lastName == null ? Restrictions.isNull("lastName") : Restrictions.eq("lastName", lastName.toUpperCase()));
		//query.setParameter("firstName", firstName);
		//query.setParameter("middleName", null);
		//query.setParameter("lastName", lastName);
		
		List user =c.list();
		
		return user;
	}
	
	@Transactional
	public User getUserbyLogin(String loginId, String password){		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session3: "+session.toString());		
		
		Criteria c = session.createCriteria(User.class);
		c.add(loginId == null ? Restrictions.isNull("loginId") : Restrictions.eq("loginId", loginId.toUpperCase()));
		c.add(password == null ? Restrictions.isNull("password") : Restrictions.eq("password", password));		
		
		User user =(User)c.uniqueResult();	  
		
		return user;
	}

	@Transactional
	public User getUserbyLoginId(String loginId){		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session3: "+session.toString());		
		
		Criteria c = session.createCriteria(User.class);
		c.add(loginId == null ? Restrictions.isNull("loginId") : Restrictions.eq("loginId", loginId.toUpperCase()));				
		
		User user =(User)c.uniqueResult();	  
		
		return user;
	}
	
	@Transactional
	public List<ContactDetail>  getContactDetailsbyUser(User user){		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session4: "+session.toString());		
		
		Query query= session.createQuery("FROM ContactDetail c where c.user=:user");
		query.setParameter("user", user);				
		
		List<ContactDetail> contactDetails =query.list();	  
		
		return contactDetails;
	}
	
	@Transactional
	public int updateContact(User user, List<ContactDetail>contactDetails){
		int status = 1;
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session5: "+session.toString());		
		Iterator i = contactDetails.iterator();
		while(i.hasNext()){
			ContactDetail contactDetail = (ContactDetail)i.next();
			contactDetail.setUser(user);
			session.saveOrUpdate(contactDetail);
			status = 0;
		}			  
		
		return status;
	}
}
