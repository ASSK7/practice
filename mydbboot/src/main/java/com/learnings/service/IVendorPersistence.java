package com.learnings.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learnings.entities.Vendor;


//vendor is the table and Long is primary key type
public interface IVendorPersistence extends JpaRepository<Vendor, Long>{
    List <Vendor> findBycompanyName(String companyName);
    //findBycompanyName - findBy + Column name . findBy is standard
    //findBy + Column name - to search on particular column for given value
    //findBy + Column name is provided by Spring
    
    
    //if you want to write custom query , observe below
    @Query(nativeQuery=true ,
    	   value="SELECT * FROM public.vendor where lower(FIRST_NAME) like %?1%")
    List <Vendor> lookUpFName(String firstName);
}
