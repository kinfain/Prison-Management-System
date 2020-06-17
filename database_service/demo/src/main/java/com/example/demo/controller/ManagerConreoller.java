package com.example.demo.controller;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Manager;
import com.example.demo.entity.Prisoner;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.util.EntityRange;

@RestController
public class ManagerConreoller {
	@Autowired
	ManagerRepository managerRepository;
	
	  // http://localhost:8761/get/prisoner/file_number=158694662881687897
	  //@GetMapping(value="/prisoner/id={id}",produces="text/html;charset=utf-8")
	  @GetMapping(value="get/mamager/file_number={id}")
	  public Manager getPrisonerByID(@PathVariable String id) {    
		  Manager usr = managerRepository.findById(id).orElse(null); 	  
		  return usr;
	  }
	  
	  @PostMapping(value="add/mamager")
	  public ResponseEntity<Manager> save(@RequestBody Manager person){
		  Manager p = managerRepository.save(person);
	      return new ResponseEntity<Manager>(p, HttpStatus.CREATED);
	  }
	  
	  @GetMapping("query/mamager/manager_birth_date/range")
	  public ResponseEntity<Page<Manager>> query(Manager person,
			  @RequestParam(value = "startDate", required = true) String startDate,
			  @RequestParam(value = "endDate", required = true) String endDate,
	          Pageable pageable){
	      Example<Manager> personExample = Example.of(person);
	      List<EntityRange<Manager>> ranges = newArrayList();
	      EntityRange<Manager> birthRange = new EntityRange<Manager>("manager_birth_date",startDate,endDate);    
	      ranges.add(birthRange);    
	      Page<Manager> page = managerRepository.queryByExampleWithRange(personExample,ranges,pageable);
	      return new ResponseEntity<Page<Manager>>(page,HttpStatus.OK);
	  }
}
