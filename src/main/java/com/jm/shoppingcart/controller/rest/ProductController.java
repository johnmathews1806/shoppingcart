package com.jm.shoppingcart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.shoppingcart.entities.Product;
import com.jm.shoppingcart.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@RequestMapping(value={"/secure/getProducts"}, method=RequestMethod.GET, produces="application/json")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PreAuthorize("hasPermission(#product,'VIEW_PRODUCT')")
	public ResponseEntity<List<Product>> get() {

		return new ResponseEntity<List<Product>>(productService.getProducts(),HttpStatus.OK);

	}

}
