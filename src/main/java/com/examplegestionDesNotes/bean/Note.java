package com.examplegestionDesNotes.bean;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Note {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private double controle;
	private double tp;
	private double exam;
	private Date anne;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Module module;
	
	

}
