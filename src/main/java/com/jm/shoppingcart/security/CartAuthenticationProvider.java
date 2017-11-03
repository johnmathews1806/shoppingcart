package com.jm.shoppingcart.security;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jm.shoppingcart.services.UserService;
import com.jm.shoppingcart.entities.User;


public class CartAuthenticationProvider implements AuthenticationProvider {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}

	String loginId = null;
	String password = null;
	SecurityContext securityContext = SecurityContextHolder.getContext();
	Authentication auth = securityContext.getAuthentication();


	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		if(auth == null) {
			loginId = authentication.getName().trim();
			password = authentication.getCredentials().toString().trim();
			User user = userService.getUserbyLoginId(loginId);
			if (user == null ) {
				throw new BadCredentialsException("Username not found.");
			}else if(!password.equals(user.getPassword())) {		   			
				throw new BadCredentialsException("Invalid Password." );		   	 
			}
			auth = new UsernamePasswordAuthenticationToken(user, password);
		}
		return auth;
	}


	public boolean supports(Class<?> authentication) {

		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
