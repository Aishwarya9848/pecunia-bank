package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //mark class as an Entity   
@Table(name="Account")	//defining class name as Table name  
public class Account {
	@Id   ////Defining accountId as primary key  
	@Column(length=12)  //length of column      
	private long accountId;
	@Column(length=8)
	private long amount;
	@Column
	private int lastTransaction;
	
	
	
	
	
	public int getLastTransaction() {
		return lastTransaction;
	}
	public void setLastTransaction(int lastTransaction) {
		this.lastTransaction = lastTransaction;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}