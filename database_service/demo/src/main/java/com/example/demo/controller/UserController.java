package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	  // http://localhost:8761/get/user/account=root
	  @GetMapping(value = "/get/user/account={id}")
	  public User getByAccount(@PathVariable String id) {
		  User usr = userRepository.findById(id).orElse(null); 	  
		  System.out.println("User:["+ usr.account + "][" + usr.password+"]");
		  return usr;
	  }
	  
	  @GetMapping(value="/delete/user/account={id}")
	  public int deletePrisoner(@PathVariable String id){
		  userRepository.deleteById(id);
	      return 1;
	  }
	  
	  
	  @PostMapping(value="/save/user")
	  public ResponseEntity<User> saveUser(@RequestBody User usr){
		  User p = userRepository.save(usr);
	      return new ResponseEntity<User>(p, HttpStatus.CREATED);
	  }
	  
}
