package com.learnings.entities;

import javax.persistence.*;

@Entity   //@Entity makes this class as table
public class address {
	
	@Id   //Makes primary key in table
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "ID")
	public Long addressId;
	@Column(name="TYPE")
	public String addressType;
	@Column(name="STREET")
	public String street;
	@Column(name="CITY")
	public String city;
	@Column(name="COUNTRY")
	public String country;
	@Column(name="REGION")
	public String region;
	

	
	//constructor without parameters
	public address() {
		
	}

	//constructor with parameters
	public address(Long addressId, String addressType, String street, String city, String country, String region) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.street = street;
		this.city = city;
		this.country = country;
		this.region = region;
	}

	
	
	//getters and setters
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	

}
