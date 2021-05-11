package com.majutre.springdemo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.domain.User;
import com.majutre.springdemo.dto.UserNewDTO;
import com.majutre.springdemo.repositories.AddressRepository;
import com.majutre.springdemo.repositories.UserRepository;
import com.majutre.springdemo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private AddressRepository addrRepository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! O Id " + id + " não existe na base de dados."));
	}

	@Transactional
	public User insert(User obj) {
		obj = repository.save(obj);
		addrRepository.saveAll(obj.getAddresses());

		return obj;
	}

	public User fromDTO(UserNewDTO objDto) {
		User user = new User(null, objDto.getName(), objDto.getEmail(), objDto.getCpf(), objDto.getBirthDate());
		Address addr = new Address(null, objDto.getCep(), objDto.getLogradouro(), objDto.getNumero(),
									objDto.getComplemento(), objDto.getBairro(), objDto.getCidade(), objDto.getEstado(), user);

		user.addAddress(addr);
		return user;
	}

	public Address addNewAddress(Long id, Address addr) {
		Address address = new Address(null, addr.getCep(), addr.getLogradouro(), addr.getNumero(),
										addr.getComplemento(), addr.getBairro(), addr.getCidade(), addr.getEstado(), findById(id));
		
		return addrRepository.save(address);

	}
}
