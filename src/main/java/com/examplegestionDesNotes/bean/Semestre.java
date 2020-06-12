package com.examplegestionDesNotes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Semestre {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nom;
	private String abreviation;
	private boolean statut = false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Boolean getStatut() {
		return statut;
	}
	public void setStatut(Boolean statut) {
		this.statut = statut;
	}
	
	
	
	
	public String getAbreviation() {
		return abreviation;
	}
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviation == null) ? 0 : abreviation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + (statut ? 1231 : 1237);
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
		Semestre other = (Semestre) obj;
		if (abreviation == null) {
			if (other.abreviation != null)
				return false;
		} else if (!abreviation.equals(other.abreviation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (statut != other.statut)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", nom=" + nom + ", abreviation=" + abreviation + ", statut=" + statut + "]";
	}
	public Semestre(Long id, String nom, String abreviation, boolean statut) {
		super();
		this.id = id;
		this.nom = nom;
		this.abreviation = abreviation;
		this.statut = statut;
	}
	public Semestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
