package com.majutre.springdemo.dto;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "O nome é obrigatório.")
	private String name;
	
	private List<Address> addresses = new ArrayList<>();
	
	public UserDTO() {
		
	}
	

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		addresses = obj.getAddresses();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
