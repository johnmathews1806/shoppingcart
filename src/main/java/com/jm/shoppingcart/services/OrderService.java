package com.jm.shoppingcart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.User;

@Service
public interface OrderService {

	public List<Order> getOrderbyUser(User user);
	public Order getOrderbyId(int orderId);
	public int createOrder(User user  , List<OrderDetail> orderDetails);
	public int deleteOrder(Order order);
}
