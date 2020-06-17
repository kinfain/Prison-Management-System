package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Jail;
import com.example.demo.repository.JailRepository;

@RestController
public class JailController {

	  @Autowired
	  private JailRepository jailRepository;
	
	
	  @GetMapping(value="get/jail/jail_number={id}")
	  public Jail getPrisonerByID(@PathVariable String id) {    
		  Jail usr = jailRepository.findById(id).orElse(null); 	  
		  return usr;
	  }
	
	
	
	
}
