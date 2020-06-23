package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "term_information")
public class TermInformation 
{  
	@Id  
	@Column
	public String file_number;
	@Column(name = "prison_term")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date prison_term;
	@Column
	public String penalty_kind;
	@Column
    public String charge;
}
