package com.majutre.springdemo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.domain.User;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;

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
	
	public AddressDTO() {
		
	}
	
	public AddressDTO(Address obj) {
		user = obj.getUser();
		cep = obj.getCep();
		logradouro = obj.getLogradouro();
		numero = obj.getNumero();
		complemento = obj.getComplemento();
		bairro = obj.getBairro();
		cidade = obj.getCidade();
		estado = obj.getEstado();
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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


	
}
