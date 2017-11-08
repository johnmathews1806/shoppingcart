package com.jm.shoppingcart.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.jm.shoppingcart.entities.User;
import com.jm.shoppingcart.services.UserService;

public class CartLogoutHandler implements LogoutSuccessHandler{

	@Autowired
	private UserService userService; 

	public void onLogoutSuccess(HttpServletRequest arg0, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		/*User user = null;
		if(authentication != null) {
			user = (User) authentication.getPrincipal();
			userService.saveOnlineStatus("N", user.getUserId());
		}*/
		response.setStatus(HttpStatus.OK.value());
		response.getWriter().flush();
	}

}
