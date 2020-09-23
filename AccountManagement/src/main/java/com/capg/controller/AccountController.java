package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.exception.IdAlreadyExistException;
import com.capg.exception.IdNotFoundException;
import com.capg.service.AccountService;






//mark class as Controller  
@RestController
//maps web requests onto methods in request-handling classes 
@RequestMapping("/bank")
@CrossOrigin("http://localhost:4200")
public class AccountController {


	//autowire the AccountService class 
	@Autowired
	private AccountService service;
	
	//creating post mapping that post the account detail in the database
	@PostMapping("/create")
	public ResponseEntity<String> addAccount(@RequestBody Customer customer ) throws IdAlreadyExistException{
		Customer customer1=service.findByAccountId(customer.getAccount().getAccountId());
		//if accountId is not equal to null it throws id already exist exception
		if(customer1!=null)
		{
			throw new IdAlreadyExistException("Account ID already exist");
		}
		else
		{
			service.addAccount(customer);
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Account created successfully",HttpStatus.OK);
			return responseEntity;
		}
	}


	//creating a get mapping that retrieves the detail of a specific account
	@GetMapping("/find/{accountId}")
	public Customer findByAccountId(@PathVariable String accountId)  {
		return service.findByAccountId(accountId);
	}

	//creating put mapping that updates the account details
	@PutMapping("/update/{account_Id}/{customerName}/{contactNumber}/{address}")
	public ResponseEntity<String> updateAccount(@PathVariable("account_Id")String accountId,@PathVariable("customerName")String customerName,
			@PathVariable("contactNumber")String contactNumber,@PathVariable("address")String address) throws IdNotFoundException {
		Customer customer=service.findByAccountId(accountId);
		//if the accountId is equal to null it throws id not found exception
		if(customer==null) {
			throw new IdNotFoundException("Plese enter Valid account Id");
		}
		else {
			ResponseEntity<String> rs=  new ResponseEntity<String>(service.updateAccount(accountId, customerName, contactNumber, address),HttpStatus.OK);
			return rs;
		}	
	}

	//creating a delete mapping that deletes a specified account 
	@DeleteMapping("/delete/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountId") String accountId) throws IdNotFoundException 
	{
		Customer customer=service.findByAccountId(accountId);
		//if the accountId is equal to null it throws id not found exception
		if(customer==null) {
			throw new IdNotFoundException("AccountId does not exist");
		}
		else {
			ResponseEntity<String> rs =  new ResponseEntity<String>(service.deleteAccount(accountId),HttpStatus.OK);
			return rs;
		}
	}
}