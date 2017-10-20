package com.jm.shoppingcart.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS_DETAILS")
public class OrderDetail implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ORDER_DETAILS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderDetailsId;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID", nullable=false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	
	public Order getOrder() { 
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() { 
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
