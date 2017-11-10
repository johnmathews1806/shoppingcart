package com.jm.shoppingcart.security;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

	SecurityContext securityContext = SecurityContextHolder.getContext();
	Authentication auth = securityContext.getAuthentication();



	public Authentication authenticate(Authentication authentication) throws AuthenticationException {		

		System.out.println("in authenticate: " +authentication);
		System.out.println("Logged in Principal: " +authentication.getPrincipal());
		System.out.println("Logged in Credential: " +authentication.getCredentials());

		if(auth != null){
			System.out.println("From Security Contexnt-in authenticate: " +auth);
			System.out.println("From Security Contexnt-Logged in Principal: " +auth.getPrincipal());
			System.out.println("From Security Contexnt-Logged in Credential: " +auth.getCredentials());
			System.out.println("From Security Contexnt-Is authenticated? "+auth.isAuthenticated());
		}
		//System.out.println("Previous auth: " +auth);
		if(auth == null) {			
			System.out.println("Is authenticated? "+authentication.isAuthenticated());			

			String loginId = authentication.getName().trim();
			System.out.println("loginId: "+loginId);

			String password = (String)authentication.getCredentials();
			System.out.println("password: "+password);			

			User user = userService.getUserbyLoginId(loginId);
			//System.out.println("user: "+user.getFirstName());
			if (user == null ) {
				System.out.println("BAD USER: ");
				throw new BadCredentialsException("Username not found.");				
			}else if(!password.equals(user.getPassword())) {
				System.out.println("INCORRECT PASSWORD ");
				throw new BadCredentialsException("Invalid Password." );		   	 
			}			
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			

			auth = new UsernamePasswordAuthenticationToken(user, password ,grantedAuths);
			//auth = new UsernamePasswordAuthenticationToken(user, password);
			//*//System.out.println("AUTH token: "+auth);			
		}
		return auth;
		//return new UsernamePasswordAuthenticationToken(user, password);
	}


	public boolean supports(Class<?> authentication) {

		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	/*public boolean supports(Class<?> arg0) {
		return true;
	}*/

}
