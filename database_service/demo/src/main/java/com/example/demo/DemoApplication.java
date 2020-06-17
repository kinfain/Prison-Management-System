package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.repository.util.WiselyRepositoryImpl;

@SpringBootApplication
@EnableEurekaServer
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    
	
}
