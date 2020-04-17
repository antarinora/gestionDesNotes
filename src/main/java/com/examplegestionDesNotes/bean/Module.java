package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Module {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private int coefficientControle;
	private int coefficientTp;
	private String designation;
	@OneToMany(mappedBy = "module")
	private List<Seance> seances;
	@OneToMany(mappedBy = "module")
	private List<ModuleFiliere> moduleFilieres;

}
