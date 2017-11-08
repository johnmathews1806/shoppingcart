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
import org.springframework.stereotype.Component;

import com.jm.shoppingcart.services.UserService;
import com.jm.shoppingcart.entities.User;

@Component
public class CartAuthenticationProvider implements AuthenticationProvider {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}

	//String loginId = null;
	//String password = null;
	SecurityContext securityContext = SecurityContextHolder.getContext();
	Authentication auth = securityContext.getAuthentication();


	public Authentication authenticate(Authentication authentication) throws AuthenticationException {



		System.out.println("in authenticate: " +authentication);
		if(auth == null) {
			
			UsernamePasswordAuthenticationToken authTemp = (UsernamePasswordAuthenticationToken) authentication;
			System.out.println("AUTH: "+authTemp);
			System.out.println("Is authenticated? "+authTemp.isAuthenticated());
			
			//String loginId = String.valueOf(authTemp.getPrincipal());
			//String password = String.valueOf(authTemp.getCredentials());

			String loginId = authentication.getName().trim();
			System.out.println("loginId: "+loginId);
			String password = authentication.getCredentials().toString().trim();
			System.out.println("password: "+password);			
			User user = userService.getUserbyLoginId(loginId);
			System.out.println("user: "+user.getFirstName());
			if (user == null ) {
				throw new BadCredentialsException("Username not found.");
			}else if(!password.equals(user.getPassword())) {		   			
				throw new BadCredentialsException("Invalid Password." );		   	 
			}			
			auth = new UsernamePasswordAuthenticationToken(user, password);
			System.out.println("AUTH token: "+auth);			
		}
		return auth;
	}


	/*	public boolean supports(Class<?> authentication) {

		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}*/

	public boolean supports(Class<?> arg0) {
		return true;
	}

}
