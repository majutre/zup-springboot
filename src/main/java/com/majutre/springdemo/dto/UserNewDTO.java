package com.majutre.springdemo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.domain.User;
import com.majutre.springdemo.services.UserService;

public class UserNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "O nome é obrigatório.")
	private String name;
	
	@NotEmpty(message = "O e-mail é obrigatório.")
	@Email(message = "E-mail inválido.")
	private String email;
	
	@NotEmpty(message = "O CPF é obrigatório.")
	//@CPF(message = "CPF inválido.")
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	private List<Address> addresses = new ArrayList<>();
	
	private Address address;
	
	@Autowired
	private UserService service;
	
	public UserNewDTO() {
		
	}
	
	public UserNewDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String estado) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
		User user = service.fromDTO(this);
		this.address = new Address(null, cep, logradouro, numero, complemento, bairro, cidade, estado, user);
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

	public String getCpf() {
		return cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public List<Address> getAddresses() {
        return addresses;
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
