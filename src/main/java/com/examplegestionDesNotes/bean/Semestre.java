package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Semestre {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String designation;
	@OneToMany(mappedBy = "semestre")
	private List<ModuleSemestre> moduleSemestres;
	

}