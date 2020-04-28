package com.examplegestionDesNotes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String cin;
	private String nom;
	private String prénom;
	private String login;
	private String motDePasse;
	private String poste;
	
	

}
