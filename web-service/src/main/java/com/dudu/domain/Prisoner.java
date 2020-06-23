package com.dudu.domain;

import java.sql.Date;


import org.springframework.format.annotation.DateTimeFormat;



public class Prisoner {

  public String file_number;
  public String political_status;
  public String education_background;
  public String name;
  public Date   birth_date;
  public String sex;
  public String native_place;
  public String nationality;
  public String address;
  public String family_background;
  public String blood_type;
  public String job;
  public Date   time_to_jail;
  public String information_in_jail; // 入监信息
  public String register_in_jail; // 入监登记

  public Date prison_term;
  public String penalty_kind;
  public String charge;
}
