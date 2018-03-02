package com.jm.shoppingcart.beans;

import java.util.List;

import com.jm.shoppingcart.entities.ContactDetail;


public class ProfileForm {

	private List<String> countries;
	private List<ContactDetail> contactDetails;
	
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	
	
}
