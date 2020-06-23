package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
import com.example.demo.entity.User;
import com.example.demo.entity.VisitPerson;
import com.example.demo.repository.VisitPersonRepository;
import com.example.demo.util.Util;

@RestController
public class VisitPersonController {

	  @Autowired
	  private VisitPersonRepository visitPersonRepository;
	 
	  
	  @GetMapping(value="/get/visit_person/visit_person_id={id}")
	  public VisitPerson getVisitPersonByID(@PathVariable String id) {    
		  VisitPerson usr = visitPersonRepository.findById(id).orElse(null); 	  
		  return usr;
	  }
	  
	  @PostMapping(value="/save/visit_person")
	  public ResponseEntity<VisitPerson> saveVisitPerson(@RequestBody VisitPerson usr){
		  VisitPerson p = visitPersonRepository.save(usr);
	      return new ResponseEntity<VisitPerson>(p, HttpStatus.CREATED);
	  }

	  @GetMapping(value="/delete/visit_person/account={id}")
	  public int deleteVisitPerson(@PathVariable String id){
		  visitPersonRepository.deleteById(id);
	      return 1;
	  }
	  
	  @GetMapping("/query/visit_person")
	  public List<VisitPerson> queryVisitPerson(
			  @RequestParam(value = "visit_person_name", required = false) String name,
			  @RequestParam(value = "visit_person_sex", required = false) String sex,
	          Pageable pageable){
		  ExampleMatcher matcher = ExampleMatcher.matching()
		            .withMatcher("visit_person_id", match->match.exact())//模糊查询匹配开头，即{username}%
		            .withMatcher("visit_person_name" ,match->match.exact())//全部模糊查询，即%{address}%
		            .withMatcher("visit_person_sex" ,match->match.exact())
		            .withMatcher("visit_times" ,match->match.exact())
		            .withIgnorePaths("relation_with_prisoner")
		            .withIgnorePaths("visit_person_remark")
		  			.withIgnorePaths("discipline_certainly")
		  			.withIgnorePaths("special_task")
		  			.withIgnorePaths("visit_person_number")
		  			.withIgnorePaths("visit_person_time")
		  			.withIgnorePaths("visit_person_record")
		  			.withIgnorePaths("visit_family_background")
		  			.withIgnorePaths("history_of_infection")
		  			.withIgnorePaths("mental_illness")
		  			.withIgnorePaths("criminal_record");	
		  System.out.println("name = " + name);
		  System.out.println("sex = " + sex);

		  VisitPerson p = new VisitPerson();
		  p.visit_person_name = new String(name);
		  p.visit_person_sex = new String(sex);
	      Example<VisitPerson> personExample = Example.of(p, matcher); 
	      
	      Page<VisitPerson> page = visitPersonRepository.queryByExample(personExample,pageable);
	      List<VisitPerson> list = page.getContent();    
	      return list;
	  }
	  
	  
	
}
