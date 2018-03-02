package com.jm.shoppingcart.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.shoppingcart.entities.AccountTransaction;
import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.Role;
import com.jm.shoppingcart.entities.User;


@Service
public class TransactionServiceImpl implements TransactionService {
	
	private SessionFactory sessionFactory;
		
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public int createTransaction(User user, AccountTransaction accountTransaction) throws HibernateException{
		int status = 1;

		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session6: "+session.toString());
		
		accountTransaction.setUser(user);
		session.persist(accountTransaction);
		
		status = 0;

		return status;
	}
}
