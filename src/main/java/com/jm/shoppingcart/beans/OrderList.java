package com.jm.shoppingcart.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderList {
	
	@JsonProperty("orderDetails")
	private List<OrderItem> orderItems;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	
}
