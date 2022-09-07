package com.learnings.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnings.entities.address;

public interface IAddressPersistance extends JpaRepository<address, Long>{

}
