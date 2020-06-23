package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "medical_history")
public class MedicalHistory 
{
	  @Id  
	  @Column(name = "file_number")
	  public String file_number;
	  @Column(name = "illness_time")
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  public Date illness_time;
	  @Column
	  public String illness_symptom;
}
