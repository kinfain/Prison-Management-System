package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity(name = "jail")
public class Jail {
	@Id  
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "jail_number")
	public String jail_number;
	@Column
	public String jail_equipment;
	@Column
	public String jail_check;
	@Column
    public String jail_have_person;
}
