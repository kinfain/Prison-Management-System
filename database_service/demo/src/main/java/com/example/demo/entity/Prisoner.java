package com.example.demo.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "prisoner")
public class Prisoner {
  @Id  
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "file_number")
  public String file_number;
  @Column
  public String political_status;
  @Column
  public String education_background;
  @Column
  public String name;
  @Column(name = "birth_date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  public Date birth_date;
  @Column
  public String sex;
  @Column
  public String native_place;
  @Column
  public String nationality;
  @Column
  public String address;
  @Column
  public String family_background;
  @Column
  public String blood_type;
  @Column
  public String job;
  @Column(name = "time_to_jail")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  public Date time_to_jail;
  @Column
  public String information_in_jail; // 入监信息
  @Column
  public String register_in_jail; // 入监登记
  
	@Column(name = "prison_term")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date prison_term;
	@Column
	public String penalty_kind;
	@Column
  public String charge;


}
