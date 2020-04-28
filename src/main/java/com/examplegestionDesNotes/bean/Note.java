package com.examplegestionDesNotes.bean;



import java.awt.List;
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
	private double PremierControle;
	private double DeuxiemeControle;
	private double tp;
	private double td;
	private int annee;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Module module;
	
	

}
