package com.majutre.springdemo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.majutre.springdemo.domain.User;
import com.majutre.springdemo.dto.UserNewDTO;
import com.majutre.springdemo.repositories.UserRepository;
import com.majutre.springdemo.resources.exceptions.FieldMessage;

public class NewUserValidator implements ConstraintValidator<NewUserValidation, UserNewDTO> {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(NewUserValidation ann) {
	}

	@Override
	public boolean isValid(UserNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		User aux = repository.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "E-mail já cadastrado."));
		}
		
		aux = repository.findByCpf(objDto.getCpf());
		if (aux != null) {
			list.add(new FieldMessage("cpf", "CPF já cadastrado."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
