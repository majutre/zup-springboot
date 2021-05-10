package com.majutre.springdemo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.dto.AddressDTO;
import com.majutre.springdemo.services.AddressService;
import com.majutre.springdemo.services.UserService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	@Autowired
	private UserService userService;
	
//	@PostMapping
//	public ResponseEntity<Void> insert(@RequestBody Address addr){
//		addr = service.insert(addr);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(addr.getId()).toUri();
//		
//		return ResponseEntity.created(uri).build();
//	}
	
	@PutMapping(value = "user/{id}")
	public ResponseEntity<Void> addNewAddressById(@Valid @RequestBody AddressDTO addressDto, @PathVariable Long id){
		Address addr = service.fromDTO(addressDto);
		addr = userService.addNewAddress(id, addr);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addr.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
