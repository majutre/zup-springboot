package com.majutre.springdemo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.services.AddressService;

@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
//	@GetMapping
//	public ResponseEntity<List<Address>> findAll() {
//		List<Address> list = service.findAll();
//		return ResponseEntity.ok().body(list);
//	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Address obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	

}
