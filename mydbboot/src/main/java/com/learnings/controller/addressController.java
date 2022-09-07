package com.learnings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.entities.address;
import com.learnings.service.addressService;

@RestController
public class addressController {
   
	@Autowired
	addressService addrSrv;
	
	
	//GET_ENTITYSET
	@RequestMapping("/address")
	public List<address> getAllAddress(){
		return addrSrv.getAddress();
	}
	
	//CREATE_ENTITY
	@PostMapping("/address")
	public address createAddress(@RequestBody address payload) {
		return addrSrv.createAddr(payload);
	}
}
