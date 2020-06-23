package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "rewords_punishments_information")
public class RewordsPunishmentsInformation {
	@Id  
	@Column
	public String file_number;
	@Column(name = "rpi_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date rpi_time;
	@Column
	public String sentencing_condition;
	@Column
    public String rpi_type;
}
