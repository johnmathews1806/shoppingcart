package com.jm.shoppingcart.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jm.shoppingcart.entities.ContactDetail;

public class ContactList {
	
	@JsonProperty("orderDetails")
	private List<ContactDetail> contactDetails;

	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	
}
