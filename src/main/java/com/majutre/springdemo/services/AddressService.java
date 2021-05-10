package com.majutre.springdemo.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
//	public List<Address> findAll() {
//		return repository.findAll();
//	}
	
	public Address insert(Address obj) {
		return repository.save(obj);
	}
	
}
