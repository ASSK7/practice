package com.learnings.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.learnings.entities.Vendor;

@Component
public class VendorService {
   
	@Autowired
	IVendorPersistence vendor;

	public List<Vendor> readAllVendors() {
        return vendor.findAll();
	}

	public Optional<Vendor> getSingleVendorById(Long vendorId) {
         return vendor.findById(vendorId);

	}
	
	public Vendor createVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
	}
	
	public Vendor changeVendor(Vendor vendorObj) {
		Optional<Vendor> myVendor = vendor.findById(vendorObj.getId());
		if(!myVendor.isPresent()) {
			return new Vendor((long)0,"","","","","","");
		}
		return vendor.save(vendorObj);
	}
	
	public String deleteVendor(Long vendorId) {
		vendor.deleteById(vendorId);
		return "Vendor Deleted Successfully";
	}
	
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findBycompanyName(companyName);
	}
	
	public List<Vendor> searchByFirstName(String firstName){
		return vendor.lookUpFName(firstName);
	}


}
