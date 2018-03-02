package com.jm.shoppingcart.entities;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "TRANSACTIONS")
public class AccountTransaction implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;	

	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	@JsonIgnore
	private User user;
	
	@Column(name = "REFERENCE_NO")
	private String referenceNo;
	
	@Column(name = "AMOUNT")
	private BigDecimal 	amount;

	@Column(name = "TRAN_DATE")
	private Date tranDate;

	public int getTransactionId() {
		return transactionId;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
