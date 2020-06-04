package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/prisoner/{id}")
  public User getPrisonerByID(@PathVariable String id) {    
      return userRepository.findById(id).orElse(null); 
  }
    
  @RequestMapping("/index")
  public String getIndex() {    
      return "index"; 
  }
  
}
