package com.capg.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capg.dao.Accountdao;
import com.capg.entity.Account;
import com.capg.entity.Customer;




//defining the business logic  
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private Accountdao dao;

	long millis=System.currentTimeMillis();  
	Date date=new Date(millis); 


	@Override
	public String addAccount(Customer customer) {
		Account account=new Account();
		account=customer.getAccount();
		account.setLastUpdated(date);
		customer.setAccount(account);
		dao.save(customer);
		return "account successfully created";
	}

	@Override
	public Customer findByAccountId(String accountId){
		return dao.findByAccountId(accountId);
	}

	@Override
	public String updateAccount(String accountId, String customerName, String contactNumber, String address) {
		dao.updateAccount(accountId,customerName,contactNumber,address);
		return "details updated succcessfully";
	}

	@Override
	public String deleteAccount(String accountId){


		dao.deletecustomer(accountId);
		dao.deleteAccount(accountId);
		return "account deleted";

	}
}
