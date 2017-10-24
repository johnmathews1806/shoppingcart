package com.jm.shoppingcart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.shoppingcart.entities.User;
import com.jm.shoppingcart.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(value={"/getUser/{loginId}"}, method=RequestMethod.GET, produces="application/json")

	public ResponseEntity<User> get(@PathVariable("loginId") String loginId) {

		return new ResponseEntity<User>(userService.getUserbyLoginId(loginId),HttpStatus.OK);

	}

}
