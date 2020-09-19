package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")	
public class Account {
	@Id   //primary
	@Column(length=12)  //length of column      
	private long accountId;
	@Column(length=15)
	private String branch;
	@Column(length=15)
	private String accountType;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}