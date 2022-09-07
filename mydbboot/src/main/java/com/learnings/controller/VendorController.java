package com.learnings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.entities.Vendor;
import com.learnings.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	VendorService VendorSrv;

	// GET_ENTITYSET
	@RequestMapping("/vendors")
	public List<Vendor> getVendors() {
		return VendorSrv.readAllVendors();
	}
	
	

	// GET_ENTITY
	@RequestMapping("/vendors/{vendorId}")
	public Vendor getVendorById(@PathVariable("vendorId") Long VendId) {
		Optional<Vendor> searchResult = VendorSrv.getSingleVendorById(VendId);
		if(!searchResult.isPresent()) { //if no id exists
			return new Vendor((long)0,"","","","","","");
		}
		return searchResult.get();

	}
	//http://localhost:8080/vendors/company?companyName=Google
	@RequestMapping("vendors/company")
	public List<Vendor> searchByCompany(@RequestParam String companyName){
		return VendorSrv.searchByCompanyName(companyName);
	}
	
	
	//http://localhost:8080/vendors/fname?firstName=hari
	@RequestMapping("vendors/fname")
	public List<Vendor> searchByFName(@RequestParam String firstName){
		return VendorSrv.searchByFirstName(firstName);
				
	}

	// Create Entity
	@PostMapping("/vendors")
	public Vendor createVendor(@RequestBody Vendor myObj) {
		return VendorSrv.createVendor(myObj);
	}

	// Update Entity
	@PutMapping("/changeVendor")
	public Vendor updateVendor(@RequestBody Vendor myObj) {
		return VendorSrv.changeVendor(myObj);
	}
	
	//delete Entity
	@RequestMapping(method=RequestMethod.DELETE,value="/vendor/{vendorId}")
	public String removeVendor(@PathVariable("vendorId") Long id) {
		return VendorSrv.deleteVendor(id);
	}

}
