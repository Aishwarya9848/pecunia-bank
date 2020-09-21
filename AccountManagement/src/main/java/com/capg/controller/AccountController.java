package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.service.AccountService;


//mark class as Controller  
@RestController
@RequestMapping("/bank")
@CrossOrigin("http://localhost:4200")
public class AccountController {

	//autowire the AccountService class 
	@Autowired
	private AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Customer> addAccount(@RequestBody Customer customer ) {
			Customer cust=service.addAccount(customer);
			ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(cust,HttpStatus.OK);
			return responseEntity;
		}
}
