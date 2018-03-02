package com.jm.shoppingcart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.AccountTransaction;
import com.jm.shoppingcart.entities.User;

@Service
public interface TransactionService {
	
	public int createTransaction(User user, AccountTransaction transaction);
	
}
