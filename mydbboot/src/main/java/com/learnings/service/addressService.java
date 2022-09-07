package com.learnings.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnings.entities.*;

@Component
public class addressService {
   
	@Autowired
	IAddressPersistance iaddress;
	
	public List<address> getAddress(){
		return iaddress.findAll();
	}
	
	public address createAddr(address payload) {
		return iaddress.save(payload);
	}
}
