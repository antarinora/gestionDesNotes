package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Filiere {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private int annee;
	private String designation;
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "filiere")
	private List<Inscription> inscriptions;
	
}
