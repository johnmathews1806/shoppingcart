package com.jm.shoppingcart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.Product;

@Service
public interface ProductService {
	public List<Product> getProducts();
	public Product getProduct(int productId);
}
