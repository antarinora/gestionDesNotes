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
	private String code;
	private String nom;
	private String abréviation;
	@OneToMany(mappedBy = "filiere")
	private List<Inscription> inscriptions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAbréviation() {
		return abréviation;
	}
	public void setAbréviation(String abréviation) {
		this.abréviation = abréviation;
	}
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abréviation == null) ? 0 : abréviation.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Filiere other = (Filiere) obj;
		if (abréviation == null) {
			if (other.abréviation != null)
				return false;
		} else if (!abréviation.equals(other.abréviation))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscriptions == null) {
			if (other.inscriptions != null)
				return false;
		} else if (!inscriptions.equals(other.inscriptions))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Filiere [id=" + id + ", code=" + code + ", nom=" + nom + ", abréviation=" + abréviation
				+ ", inscriptions=" + inscriptions + "]";
	}
	public Filiere(Long id, String code, String nom, String abréviation, List<Inscription> inscriptions) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.abréviation = abréviation;
		this.inscriptions = inscriptions;
	}
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
