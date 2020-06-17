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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.collect.Lists.newArrayList;

import com.example.demo.entity.Prisoner;
import com.example.demo.repository.PrisonerRepository;
import com.example.demo.repository.util.EntityRange;
import com.example.demo.util.Util;;


@RestController
public class PrisonerController {
  @Autowired
  private PrisonerRepository prisonerRepository;
 
  // http://localhost:8761/get/prisoner/file_number=158694662881687897
  //@GetMapping(value="/prisoner/id={id}",produces="text/html;charset=utf-8")
  @GetMapping(value="get/prisoner/file_number={id}")
  public Prisoner getPrisonerByID(@PathVariable String id) {    
	  Prisoner usr = prisonerRepository.findById(id).orElse(null); 	  
	  return usr;
  }
  
  
  @PostMapping(value="add/prisoner")
  public ResponseEntity<Prisoner> save(@RequestBody Prisoner person){
  	Prisoner p = prisonerRepository.save(person);
      return new ResponseEntity<Prisoner>(p, HttpStatus.CREATED);
  }
  
  
  @GetMapping("query/prisoner")
  public ResponseEntity<Page<Prisoner>> query(
		  @RequestParam(value = "name", required = false) String name,
		  @RequestParam(value = "sex", required = false) String sex,
		  @RequestParam(value = "birth_date", required = false) String birth_date,
		  @RequestParam(value = "blood_type", required = false) String blood_type,
          Pageable pageable){
	  ExampleMatcher matcher = ExampleMatcher.matching()
	            .withMatcher("name", match->match.exact())//模糊查询匹配开头，即{username}%
	            .withMatcher("sex" ,match->match.exact())//全部模糊查询，即%{address}%
	            .withMatcher("birth_date" ,match->match.exact())
	            .withMatcher("blood_type" ,match->match.exact());
//	            .withIgnorePaths("file_number")//忽略字段，即不管password是什么值都不加入查询条件
//	            .withIgnorePaths("political_status")  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//	  			.withIgnorePaths("education_background")
//	  			.withIgnorePaths("native_place")
//	  			.withIgnorePaths("nationality")
//	  			.withIgnorePaths("address")
//	  			.withIgnorePaths("family_background")
//	  			.withIgnorePaths("job")
//	  			.withIgnorePaths("time_to_jail")
//	  			.withIgnorePaths("information_in_jail")
//	  			.withIgnorePaths("register_in_jail");	
	  System.out.println("name = " + name);
	  System.out.println("sex = " + sex);
	  System.out.println("birth_date = " + birth_date);
	  System.out.println("blood_type = " + blood_type);
	  Prisoner p = new Prisoner();
	  p.name = new String(name);
	  p.sex = new String(sex);
	  p.birth_date = Util.strToDate(birth_date);
	  p.blood_type = new String(blood_type);
      Example<Prisoner> personExample = Example.of(p, matcher); 
      
      Page<Prisoner> page = prisonerRepository.queryByExample(personExample,pageable);
      return new ResponseEntity<Page<Prisoner>>(page,HttpStatus.OK);
  }
  
  
  /**
   * post请求
   *
   * http://localhost:8718/login?name=111+&pwd=111
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String test6(@RequestParam(value = "name", required = true) String name,
                            @RequestParam(value = "pwd", required = true) String pwd) {
      if (name.equals("admin") && pwd.equals("admin")) {
          return "true";
      } else {
          return "false";
      }
  }
//  @GetMapping("/prisoner/name={id}")
//  public User getPrisonerByName(@PathVariable String id) {    
//	  
//      return userRepository.(id).orElse(null); 
//  }

  
}
