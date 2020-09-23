package com.capg.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity  
@Entity
//defining class name as Table name  
@Table(name="Account")	
public class Account {
	//Defining accountId as primary key 
	@Id   
	@Column(length=12)  //length of column      
	private String accountId;
	@Column(length=8)
	private Long amount;
	@Column(length=20)
	private Date lastUpdated;
	
	//generating getters and setters
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
}
