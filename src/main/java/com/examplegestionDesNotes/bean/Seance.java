package com.examplegestionDesNotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seance {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String cours;
	private Date date;
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne
	private Module module;
	
	

}