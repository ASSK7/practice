package com.learnings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.businesslogicS.vendorOperationS;
import com.learnings.entities.vendor;

@RestController
public class vendorController {
	
	
	@Autowired
	vendorOperationS vendorRepo;
	
	
	@RequestMapping("/vendors")
	public List<vendor> getAllVendors(){
		
		return vendorRepo.getAllVendors();
		
	}

}
