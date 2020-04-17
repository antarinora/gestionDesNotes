package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enseignant {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private String departement;
	private String motDePasse;
	@OneToMany(mappedBy = "enseignant")
	private List<Seance> seances;

}