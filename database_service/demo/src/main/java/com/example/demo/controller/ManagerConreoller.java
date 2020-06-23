package com.example.demo.controller;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import com.example.demo.util.Util;

@RestController
public class ManagerConreoller {
	@Autowired
	ManagerRepository managerRepository;
	
//	   http://localhost:8761/get/prisoner/file_number=158694662881687897
//	  @GetMapping(value="/prisoner/id={id}",produces="text/html;charset=utf-8")
	  @GetMapping(value="/get/mamager/manager_file_number={id}")
	  public Manager getManager(@PathVariable String id) {    
		  Manager usr = managerRepository.findById(id).orElse(null); 	  
		  return usr;
	  }
	  
	  @PostMapping(value="/save/mamager")
	  public ResponseEntity<Manager> saveManager(@RequestBody Manager person){
		  Manager p = managerRepository.save(person);
	      return new ResponseEntity<Manager>(p, HttpStatus.CREATED);
	  }
	  
	  @GetMapping(value="/delete/mamager/manager_file_number={id}")
	  public int deleteManager(@PathVariable String id){
		  managerRepository.deleteById(id);
	      return 1;
	  }
	  
	  @GetMapping("/query/manager")
	  public List<Manager> queryManager(
			  @RequestParam(value = "manager_name", required = false) String name,
			  @RequestParam(value = "manager_sex", required = false) String sex,
			  @RequestParam(value = "manager_birth_date", required = false) String birth_date,
			  @RequestParam(value = "manager_blood_type", required = false) String blood_type,
			  @PageableDefault Pageable pageable){
		  ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("manager_name", match->match.exact());
		  if(sex!=null)
			  matcher=matcher.withMatcher("manager_sex" ,match->match.exact());
		  if(birth_date!=null)
			  matcher=matcher.withMatcher("manager_birth_date" ,match->match.exact());
		  if(blood_type!=null)
			  matcher=matcher.withMatcher("manager_blood_type" ,match->match.exact());
		  System.out.println("manager_name = " + name);
		  System.out.println("manager_sex = " + sex);
		  System.out.println("manager_birth_date = " + birth_date);
		  System.out.println("manager_blood_type = " + blood_type);
		  Manager p = new Manager();
		  p.manager_name = new String(name);
		  p.manager_sex = new String(sex);
		  p.manager_birth_date = Util.strToDate(birth_date);
		  p.manager_blood_type = new String(blood_type);
	      Example<Manager> personExample = Example.of(p, matcher); 
	      
	      Page<Manager> page = managerRepository.queryByExample(personExample,pageable);
	      List<Manager> list = page.getContent();    
	      return list;
	  }
	  
	  
	  
}
