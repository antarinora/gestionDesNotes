package com.examplegestionDesNotes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class filiere {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private int annee;
	private String designation;
	
}
