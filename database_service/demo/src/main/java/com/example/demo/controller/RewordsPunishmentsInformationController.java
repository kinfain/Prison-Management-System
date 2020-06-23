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
import com.example.demo.entity.RewordsPunishmentsInformation;
import com.example.demo.entity.TermInformation;
import com.example.demo.repository.RewordsPunishmentsInformationRepository;

@RestController
public class RewordsPunishmentsInformationController {
	
	
	@Autowired
	RewordsPunishmentsInformationRepository rewordsPunishmentsInformationRepository;
	
	
	  @PostMapping(value="/save/rewords_punishments_information")
	  public ResponseEntity<RewordsPunishmentsInformation> saveRewordsPunishmentsInformation(@RequestBody RewordsPunishmentsInformation usr){
		  RewordsPunishmentsInformation p = rewordsPunishmentsInformationRepository.save(usr);
	      return new ResponseEntity<RewordsPunishmentsInformation>(p, HttpStatus.CREATED);
	  }
	
	  @PostMapping(value="/delete/rewords_punishments_information")
	  public int deleteRewordsPunishmentsInformation(@RequestBody RewordsPunishmentsInformation person){
		  rewordsPunishmentsInformationRepository.delete(person);
	      return 1;
	  }
	
	  // http://localhost:8761/get/prisoner/file_number=158694662881687897
	  //@GetMapping(value="/prisoner/id={id}",produces="text/html;charset=utf-8")
	  @GetMapping(value="/get/rewords_punishments_information/file_number={id}")
	  public List<RewordsPunishmentsInformation> getMedicalHistory(
			  @PathVariable String id,
			  @PageableDefault Pageable pageable
	  ) {  
		  
		  ExampleMatcher matcher = ExampleMatcher.matching()
		            .withMatcher("file_number", match->match.exact())
		  			.withIgnorePaths("rpi_time")
		  			.withIgnorePaths("sentencing_condition")
		  			.withIgnorePaths("rpi_type");
		  MedicalHistory p = new MedicalHistory();
		  p.file_number = new String(id);
	      Example<MedicalHistory> personExample = Example.of(p, matcher); 
	      
	      Page<RewordsPunishmentsInformation> page = rewordsPunishmentsInformationRepository.queryByExample(personExample,pageable);
	      List<RewordsPunishmentsInformation> list = page.getContent();      
	      return list;
	  }
	
}
