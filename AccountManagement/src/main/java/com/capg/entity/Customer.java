package com.capg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capg.entity.Account;
//mark class as an Entity  
@Entity
//defining class name as Table name  
@Table(name="Customer")
public class Customer  {
	//Defining aadharNumber as primary key 
	@Id
	@Column(length=12) //specifies column details
	private String aadharNumber;
	@Column(length=20)  //length of the column
	private String customerName;
	@Column(length=15)
	private String contactNumber;
	@Column(length=15)
	private String panNumber;
	@Column(length=15)
	private String dateOfBirth;
	@Column(length=6)
	private String gender;
	@Column(length=15)
	private String address;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accountId")
	private Account account;
	
	
	//generating getters and setters
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
