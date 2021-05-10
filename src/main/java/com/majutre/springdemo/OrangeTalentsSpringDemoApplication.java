package com.majutre.springdemo;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.majutre.springdemo.domain.Address;
import com.majutre.springdemo.domain.User;
import com.majutre.springdemo.repositories.AddressRepository;
import com.majutre.springdemo.repositories.UserRepository;

@SpringBootApplication
public class OrangeTalentsSpringDemoApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrangeTalentsSpringDemoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maju", "email@gmail.com", "12312312321", LocalDate.parse("1990-06-30"));
		User user2 = new User(null, "Matheus", "matt@gmail.com", "32132132121", LocalDate.parse("1991-09-06"));
		
		Address addr1 = new Address(null, "05555123", "Rua X", "140", "Bloco A", "Pinheiros", "Sao Paulo", "SP", user1);
		Address addr2 = new Address(null, "12321444", "Rua Y", "240", "Casa 01", "Vila Mariana", "Rio de Janeiro", "RJ", user2);
		Address addr3 = new Address(null, "00447111", "Rua Z", "340", "complemento", "Sumare", "Sao Paulo", "SP", user1);
		
		user1.getAddresses().addAll(Arrays.asList(addr1, addr3));
		user1.getAddresses().add(addr2);

		userRepository.saveAll(Arrays.asList(user1, user2));
		addressRepository.saveAll(Arrays.asList(addr1, addr2, addr3));
		
	}

	
}
