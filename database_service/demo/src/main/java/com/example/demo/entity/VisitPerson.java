package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "visit_person")
public class VisitPerson {
	  @Id  
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  @Column(name = "visit_person_id")
	  public String visit_person_id;
	  @Column
	  public String visit_person_name;
	  @Column
	  public String visit_person_sex;
	  @Column
	  public int visit_times;
	  
	  @Column
	  public String relation_with_prisoner;
	  @Column
		public String visit_person_remark;
	  @Column
		public String discipline_certainly;
	  @Column
		public String special_task;
	  @Column
		public int visit_person_number;

	  @Column
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
		public Date visit_person_time;

	  @Column
		public String visit_person_record;
	  @Column
		public String visit_family_background;
	  @Column
		public String history_of_infection;
	  
	  @Column
		public String mental_illness;
	  @Column
		public String criminal_record;
}
