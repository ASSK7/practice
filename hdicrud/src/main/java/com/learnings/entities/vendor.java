package com.learnings.entities;

import org.springframework.stereotype.Component;


public class vendor {
    
	
	private String id;
	private String firstName;
	private String lastName;
	private String companyName;
	private String website;
	private String email;
	private String vstatus;
	private String gstNumber;
	
	
	
	
	public vendor() {
		
	};
	
	
	public vendor(String id, String firstName, String lastName, String companyName, String website, String email,
			String vstatus, String gstNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.website = website;
		this.email = email;
		this.vstatus = vstatus;
		this.gstNumber = gstNumber;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVstatus() {
		return vstatus;
	}
	public void setVstatus(String vstatus) {
		this.vstatus = vstatus;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	
	
	
	
	
}
