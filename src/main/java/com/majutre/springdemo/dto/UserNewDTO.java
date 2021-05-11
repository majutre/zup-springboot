package com.majutre.springdemo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.services.validation.NewUserValidation;

@NewUserValidation
public class UserNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "O nome é obrigatório.")
	private String name;
	
	@NotEmpty(message = "O e-mail é obrigatório.")
	@Email(message = "E-mail inválido.")
	
	private String email;
	
	@NotEmpty(message = "O CPF é obrigatório.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	@NotEmpty(message = "O CEP é obrigatório.")
	private String cep;
	
	@NotEmpty(message = "O logradouro é obrigatório.")
	private String logradouro;
	
	@NotEmpty(message = "O número é obrigatório.")
	private String numero;
	
	@NotEmpty(message = "O complemento é obrigatório.")
	private String complemento;
	
	@NotEmpty(message = "O bairro é obrigatório.")
	private String bairro;
	
	@NotEmpty(message = "Insira uma cidade.")
	private String cidade;
	
	@NotEmpty(message = "Insira um estado.")
	private String estado;

	private List<Address> addresses = new ArrayList<>();
	
	public UserNewDTO() {
		
	}
	
	public UserNewDTO(Long id, String name, String email, String cpf, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
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

	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
