package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.repository.util.WiselyRepository;


//@Repository
public interface UserRepository extends WiselyRepository<User, String> {
	
}