package com.majutre.springdemo.resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.majutre.springdemo.domain.ViaCepAddress;

@RestController
public class ViaCepResource implements Serializable {

	  private static final long serialVersionUID = 1L;

	  @GetMapping(value="/addresses/{cep}")
	  public ResponseEntity<ViaCepAddress> doGetCep(@PathVariable(name = "cep") String cep) {

	    RestTemplate restTemplate = new RestTemplate();
	    
	    String uri = "http://viacep.com.br/ws/{cep}/json/";

	    Map<String, String> params = new HashMap<String, String>();
	    params.put("cep", cep);

	    ViaCepAddress viaCepAddr = restTemplate.getForObject(uri, ViaCepAddress.class, params);
	    
	    return ResponseEntity.ok().body(viaCepAddr);
	  }

	}