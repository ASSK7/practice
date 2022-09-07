package com.learnings.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.persistence.*;
//import javax.persistence.*;
import javax.persistence.Table;
import com.learnings.entities.address;
import com.learnings.service.IAddressPersistance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity // makes this class as table
@Table(name = "VENDOR") // Naming the table
public class Vendor {

	@Id
	@Column(nullable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(name = "COMPANY_NAME")
	public String companyName;
	@Column(name = "FIRST_NAME")
	public String firstName;
	@Column(name = "LAST_NAME")
	public String lastName;
	@Column(name = "EMAIL")
	public String email;
	@Column(name = "WEBSITE")
	public String website;
	@Column(name = "STATUS")
	public String status;
	
	
	//for foriegn key relationship to address table
	//Cascade all means Create,update,delete happens to address table along with vendor table
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor", referencedColumnName = "ID")
	private List<address> addresses = new ArrayList<>();
	


	// empty constructor
	public Vendor() {

	}

	public Vendor(Long id, String companyName, String firstName, String lastName, String email, String website,
			String status) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.website = website;
		this.status = status;
//		this.addresses = addresses;
	}
    


	// getters & setters are compulsory
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
   
	
	//getter and setters methods for foriegn key relationship
	public List<address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<address> addresses) {
		this.addresses = addresses;
	}

    
	

}
