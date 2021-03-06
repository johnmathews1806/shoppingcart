package com.jm.shoppingcart.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.shoppingcart.beans.OrderItem;
import com.jm.shoppingcart.beans.OrderList;
import com.jm.shoppingcart.entities.Order;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.Product;
import com.jm.shoppingcart.entities.User;
import com.jm.shoppingcart.services.OrderService;
import com.jm.shoppingcart.services.ProductService;
import com.jm.shoppingcart.services.UserService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired	
	private UserService userService;

	@Autowired
	private ProductService prodService;


	@RequestMapping(value={"/secure/createOrder/{loginId}"}, method=RequestMethod.POST)
	@PreAuthorize("hasPermission(#loginId,'CREATE_ORDER')")
	public ResponseEntity<Integer> createOrder(@PathVariable("loginId") String loginId, @RequestBody String orderRequest) {

		System.out.println("User : "+loginId);		
		System.out.println("order details: "+orderRequest);
		ObjectMapper mapper = new ObjectMapper();
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();		

		try {
			List<OrderItem> orderList = mapper.readValue(orderRequest, OrderList.class).getOrderItems();
			for(OrderItem order : orderList){
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setProduct(prodService.getProduct(order.getProductId()));
				orderDetail.setAmount(order.getAmount());
				orderDetail.setQuantity(order.getQuantity());
				orderDetails.add(orderDetail);
				System.out.println("order item : "+order.getProductId());
				System.out.println("order item : "+order.getProductName());	
			}
			System.out.println("order item list: "+orderDetails);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return new ResponseEntity<Integer>(orderService.createOrder(userService.getUserbyLoginId(loginId), orderDetails),HttpStatus.OK);
		//return new ResponseEntity(Integer.valueOf(0),HttpStatus.OK);

	}

	@RequestMapping(value={"/secure/getOrders/"}, method=RequestMethod.GET, produces="application/json")
	@PreAuthorize("hasPermission(#order,'VIEW_ORDER')")
	public ResponseEntity<List<Order>> get(Authentication authentication) {		
		User user = (User)authentication.getPrincipal();
		System.out.println("IN GET ORDERS: "+user.getLoginId());
		return new ResponseEntity<List<Order>>(orderService.getOrderbyUser(userService.getUserbyLoginId(user.getLoginId())),HttpStatus.OK);	
	}

	@RequestMapping(value={"/secure/deleteOrder/{orderId}"}, method=RequestMethod.DELETE)
	@PreAuthorize("hasPermission(#order,'DELETE_ORDER')")
	public ResponseEntity<Integer> delete(@PathVariable("orderId") int orderId) {

		return new ResponseEntity<Integer>(orderService.deleteOrder(orderService.getOrderbyId(orderId)),HttpStatus.OK);

	}

}
