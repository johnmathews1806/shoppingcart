package com.jm.shoppingcart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.User;

@Service
public interface UserService {
	public List<User> searchUserByName(String firstName, String middleName, String lastName);
	public List<User> getUserByName(String firstName, String middleName, String lastName);
	public User getUserbyLogin(String loginId, String password);
	public User getUserbyLoginId(String loginId);
	public List<ContactDetail>  getContactDetailsbyUser(User user);
	public int updateContact(User user, List<ContactDetail>contactDetails);
	public int createUser(User user, ContactDetail contactDetails);
	
}
