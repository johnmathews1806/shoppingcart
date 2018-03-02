package com.jm.shoppingcart.jms.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Transaction.java" is the root-element of our example
@XmlRootElement(name="transaction", namespace = "com.jm.shoppingcart.jms.jaxb")
public class TransactionBinding {
	    
	    private String userId;
	    // XmlElement sets the name of the entities
	    //@XmlElement(name = "referenceNumber")
	    private String referenceNo;
	    private String amount;
	    private String tranDate;
	    
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getReferenceNo() {
			return referenceNo;
		}
		public void setReferenceNo(String referenceNo) {
			this.referenceNo = referenceNo;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getTranDate() {
			return tranDate;
		}
		public void setTranDate(String tranDate) {
			this.tranDate = tranDate;
		}

}
