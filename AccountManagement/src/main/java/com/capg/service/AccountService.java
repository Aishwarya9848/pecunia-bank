package com.capg.service;

import com.capg.entity.Customer;



public interface AccountService {
	String addAccount(Customer customer);

	Customer findByAccountId(String accountId);

	String updateAccount(String accountId, String customerName, String contactNumber, String address);

	String deleteAccount(String accountId);
}
