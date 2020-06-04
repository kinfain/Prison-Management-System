package com.example.demo.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "prisoner")
public class User {
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
  @Column
  public String time_to_jail;
  @Column
  public String information_in_jail; // 入监信息
  @Column
  public String register_in_jail; // 入监登记
  


}
