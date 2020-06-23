package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Jail;
import com.example.demo.repository.JailRepository;

@RestController
public class JailController {

	  @Autowired
	  private JailRepository jailRepository;
	
	
	  @GetMapping(value="/get/jail/jail_number={id}")
	  public Jail getPrisonerByID(@PathVariable String id) {    
		  Jail usr = jailRepository.findById(id).orElse(null); 	  
		  return usr;
	  }
	
	
	  @PostMapping(value="/save/jail")
	  public ResponseEntity<Jail> saveJail(@RequestBody Jail person){
		  Jail p = jailRepository.save(person);
	      return new ResponseEntity<Jail>(p, HttpStatus.CREATED);
	  }
	  
	  @GetMapping(value="/delete/jail/jail_number={id}")
	  public int deleteJail(@PathVariable String id){
		  jailRepository.deleteById(id);
	      return 1;
	  }
}
