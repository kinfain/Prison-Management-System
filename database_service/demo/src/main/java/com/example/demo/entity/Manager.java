package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "manager_information")
public class Manager {
	
	  @Id  
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  @Column(name = "manager_file_number")
	public String manager_file_number;
	  @Column
	public String manager_politics_status;
	  @Column
	public String manager_education_background;
	  @Column
		public String manager_name;
	  
	  @Column(name = "manager_birth_date")
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
		public String manager_birth_date;
	  @Column
		public String manager_sex;
	  @Column
		public String manager_native_place;
	  @Column
		public String manager_nationality;
	  @Column
		public String manager_address;

	  @Column
		public String manager_family_background;

	  @Column
		public String manager_blood_type;
	  @Column
		public String manager_meidical_history;
	  @Column
		public String manager_work;
	  
	  @Column(name = "manager_entry_time")
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
		public String manager_entry_time;
	  @Column
		public String manager_entry_information;
}
