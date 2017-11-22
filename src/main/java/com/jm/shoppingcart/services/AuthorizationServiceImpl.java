package com.jm.shoppingcart.services;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.Permission;

public class AuthorizationServiceImpl implements AuthorizationService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Set<Permission> getPermissions(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
