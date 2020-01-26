package com.example.springdemo.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Hrushikesh
 *
 */
@RestController
@RequestMapping(path = "/demo")
public class CustomerController {

	static List<CustomerDetails> customerList = new ArrayList<CustomerDetails>();

	static {
		CustomerDetails customerDetails1 = new CustomerDetails();
		customerDetails1.setCustomerId(45444);
		customerDetails1.setCustomerName("Jamie Dimon");
		customerDetails1.setCustomerAddress("New York");
		customerDetails1.setBusinessUnit("Risk Portfolio");

		customerDetails1.setCustomerId(12256);
		customerDetails1.setCustomerName("Micheal Copon");
		customerDetails1.setCustomerAddress("California");
		customerDetails1.setBusinessUnit("Risk Portfolio");

		CustomerDetails customerDetails2 = new CustomerDetails();
		customerDetails2.setCustomerId(35256);
		customerDetails2.setCustomerName("Joe Rogan");
		customerDetails2.setCustomerAddress("Chicago");
		customerDetails2.setBusinessUnit("Risk Portfolio");

		CustomerDetails customerDetails3 = new CustomerDetails();
		customerDetails3.setCustomerId(688256);
		customerDetails3.setCustomerName("Jhon Depp");
		customerDetails3.setCustomerAddress("Chicago");
		customerDetails3.setBusinessUnit("Risk Portfolio");

		CustomerDetails customerDetails4 = new CustomerDetails();
		customerDetails4.setCustomerId(86597);
		customerDetails4.setCustomerName("Alan Doo");
		customerDetails4.setCustomerAddress("New York");
		customerDetails4.setBusinessUnit("Risk Portfolio");

		customerList.add(customerDetails1);
		customerList.add(customerDetails2);
		customerList.add(customerDetails3);
		customerList.add(customerDetails4);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/GetCustomerDetails")
	public ResponseEntity<?> getCustomerDetails() {

		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/addCustomerDetails")
	public ResponseEntity<?> addCustomerDetails(@RequestBody CustomerDetails customerDetails) {

		customerList.add(customerDetails);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
}
