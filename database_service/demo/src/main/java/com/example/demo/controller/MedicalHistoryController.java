package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Manager;
import com.example.demo.entity.MedicalHistory;
import com.example.demo.entity.Prisoner;
import com.example.demo.repository.MedicalHistoryRepository;



@RestController
public class MedicalHistoryController {

	
	@Autowired
	MedicalHistoryRepository medicalHistoryRepository;
	
	  @PostMapping(value="/save/medical_history")
	  public ResponseEntity<MedicalHistory> saveMedicalHistory(@RequestBody MedicalHistory person){
		  MedicalHistory p = medicalHistoryRepository.save(person);
	      return new ResponseEntity<MedicalHistory>(p, HttpStatus.CREATED);
	  }
	
	  @PostMapping(value="/delete/medical_history")
	  public int deleteMedicalHistory(@RequestBody MedicalHistory person){
		  medicalHistoryRepository.delete(person);
	      return 1;
	  }
	  
	  // http://localhost:8761/get/prisoner/file_number=158694662881687897
	  //@GetMapping(value="/prisoner/id={id}",produces="text/html;charset=utf-8")
	  @GetMapping(value="/get/medical_history/file_number={id}")
	  public List<MedicalHistory> getMedicalHistory(
			  @PathVariable String id,
			  @PageableDefault Pageable pageable
	  ) {  
		  
		  ExampleMatcher matcher = ExampleMatcher.matching()
		            .withMatcher("file_number", match->match.exact())
		  			.withIgnorePaths("illness_time")
		  			.withIgnorePaths("illness_symptom")
		  			.withIgnorePaths("register_in_jail");
		  MedicalHistory p = new MedicalHistory();
		  p.file_number = new String(id);
	      Example<MedicalHistory> personExample = Example.of(p, matcher); 
	      
	      Page<MedicalHistory> page = medicalHistoryRepository.queryByExample(personExample,pageable);
	      List<MedicalHistory> list = page.getContent();
	      
	      return list;
	  }
	  
}
