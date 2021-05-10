package com.majutre.springdemo.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.majutre.springdemo.domain.Address;

public class UserRequest {

	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String cpf;
	
	private LocalDate birthDate;

	private List<Address> addresses = new ArrayList<>();
	
	public UserRequest() {
		
	}
	
	public UserRequest(Long id, String name, String email, String cpf, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
