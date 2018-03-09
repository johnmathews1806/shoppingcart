package com.jm.shoppingcart.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.shoppingcart.beans.ContactList;
import com.jm.shoppingcart.beans.OrderItem;
import com.jm.shoppingcart.beans.OrderList;
import com.jm.shoppingcart.beans.ProfileForm;
import com.jm.shoppingcart.beans.RegistrationDetails;
import com.jm.shoppingcart.entities.ContactDetail;
import com.jm.shoppingcart.entities.OrderDetail;
import com.jm.shoppingcart.entities.User;
import com.jm.shoppingcart.services.UserService;
import com.jm.cms.webservices.Country;
import com.jm.cms.webservices.CountryService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping(value={"/secure/getUser/{loginId}"}, method=RequestMethod.GET, produces="application/json")
	@PreAuthorize("hasPermission(#user,'VIEW_PROFILE')")
	public ResponseEntity<User> get(@PathVariable("loginId") String loginId) {

		return new ResponseEntity<User>(userService.getUserbyLoginId(loginId),HttpStatus.OK);

	}

/*	@RequestMapping(value={"/secure/getContactDetails/{loginId}"}, method=RequestMethod.GET, produces="application/json")
	@PreAuthorize("hasPermission(#contactDetails,'VIEW_PROFILE')")
	public ResponseEntity<List<ContactDetail>> getContactDetails(@PathVariable("loginId") String loginId) {

		return new ResponseEntity<List<ContactDetail>>(userService.getContactDetailsbyUser(userService.getUserbyLoginId(loginId)),HttpStatus.OK);

	}*/
	
	@RequestMapping(value={"/secure/getContactDetails/{loginId}"}, method=RequestMethod.GET, produces="application/json")
	@PreAuthorize("hasPermission(#contactDetails,'VIEW_PROFILE')")
	public ResponseEntity<ProfileForm> getContactDetails(@PathVariable("loginId") String loginId) {
		ProfileForm pf = new ProfileForm();
		
		CountryService cs = new CountryService();
        Country c = cs.getCountryPort();
        System.out.println("from webservice: "+c.getCountries());
		pf.setCountries(c.getCountries());
		pf.setContactDetails(userService.getContactDetailsbyUser(userService.getUserbyLoginId(loginId)));
		return new ResponseEntity<ProfileForm>(pf,HttpStatus.OK);

	}
	
	
	@RequestMapping(value={"/secure/updateContacts/{loginId}"}, method=RequestMethod.POST)
	@PreAuthorize("hasPermission(#loginId,'UPDATE_PROFILE')")
	public ResponseEntity<Integer> updateContacts(@PathVariable("loginId") String loginId, @RequestBody List<ContactDetail> contactDetails) {

		System.out.println("User : "+loginId);		
		System.out.println("contact details: "+contactDetails);
		/*ObjectMapper mapper = new ObjectMapper();
		List<ContactDetail> contactDetails = new ArrayList<ContactDetail>();		
		
		try {
			contactDetails = mapper.readValue(updateContactRequest, ContactList.class).getContactDetails();			
			System.out.println("order item list: "+contactDetails);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		return new ResponseEntity<Integer>(userService.updateContact(userService.getUserbyLoginId(loginId), contactDetails),HttpStatus.OK);

	}
	
	@RequestMapping(value={"/register/"}, method=RequestMethod.POST)	
	public ResponseEntity<Integer> register(@RequestBody RegistrationDetails registrationDetails) {				
		System.out.println("registration details: "+registrationDetails);
		User user = new User();
		user.setLoginId(registrationDetails.getEmailId().toUpperCase());
		user.setPassword(registrationDetails.getPassword());
		user.setFirstName(registrationDetails.getFirstName());
		user.setMiddleName(registrationDetails.getMiddleName());
		user.setLastName(registrationDetails.getLastName());
		user.setDob(registrationDetails.getDob());		
		
		ContactDetail contactDetail = new ContactDetail();
		contactDetail.setAddress1(registrationDetails.getAddress1());
		contactDetail.setAddress2(registrationDetails.getAddress2());
		contactDetail.setCity(registrationDetails.getCity());
		contactDetail.setState(registrationDetails.getState());
		contactDetail.setCountry(registrationDetails.getCountry());
		contactDetail.setEmailId(registrationDetails.getEmailId());
		contactDetail.setPhone(registrationDetails.getPhone());
		contactDetail.setMobile(registrationDetails.getMobile());
		
		return new ResponseEntity<Integer>(userService.createUser(user,contactDetail),HttpStatus.OK);

	}

}
