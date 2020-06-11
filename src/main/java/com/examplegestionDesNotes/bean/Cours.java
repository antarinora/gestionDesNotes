package com.examplegestionDesNotes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cours {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String annee;
	
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne
	private Module module;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	@Override
	public String toString() {
		return "Seance [id=" + id + ", annee=" + annee +  ", enseignant=" + enseignant + ", module="
				+ module + "]";
	}
	public Cours(Long id, String annee, Enseignant enseignant, Module module) {
		super();
		this.id = id;
		this.annee = annee;
		this.enseignant = enseignant;
		this.module = module;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		return true;
	}
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
