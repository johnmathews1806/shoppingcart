package com.jm.shoppingcart.entities;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	@OneToMany(mappedBy="order")
	private Collection<OrderDetail> orderDetails;
	
	@Column(name = "TOTAl")
	private BigDecimal total;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Column(name = "PAID_FLAG")
	private String paidFlag;
	
	@Column(name = "PAID_DATE")
	private Date paidDate;
	
	@Column(name = "CANCEL_FLAG")
	private String cancelFlag;
	
	@Column(name = "CANCEL_DATE")
	private Date cancelDate;
	
	@Column(name = "REVERSED_FLAG")
	private String reversedFlag;
	
	@Column(name = "REVERSAL_DATE")
	private Date reversalDate;
	
	@Column(name = "DELIVERED_FLAG")
	private String deliveredFlag;
	
	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name = "ORDER_STATUS")
	private String orderStatus;

	public User getuser() { 
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	
	public void addContactDetails(OrderDetail orderDetail){
		if(!orderDetails.contains(orderDetail)){
			orderDetails.add(orderDetail);
		}
		
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaidFlag() {
		return paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getReversedFlag() {
		return reversedFlag;
	}

	public void setReversedFlag(String reversedFlag) {
		this.reversedFlag = reversedFlag;
	}

	public Date getReversalDate() {
		return reversalDate;
	}

	public void setReversalDate(Date reversalDate) {
		this.reversalDate = reversalDate;
	}

	public String getDeliveredFlag() {
		return deliveredFlag;
	}

	public void setDeliveredFlag(String deliveredFlag) {
		this.deliveredFlag = deliveredFlag;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
