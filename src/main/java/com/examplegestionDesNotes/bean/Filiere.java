package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filiere {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private int annee;
	private String designation;
	@OneToMany(mappedBy = "filiere")
	private List<Inscription> inscriptions;
	@OneToMany(mappedBy = "filiere")
	private List<ModuleFiliere> moduleFilieres;
}
