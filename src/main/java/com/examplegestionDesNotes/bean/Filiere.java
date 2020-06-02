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
	private String code;
	private String nom;
	private String abreviation;
    @OneToMany(mappedBy = "filiere")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
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
	public String getAbreviation() {
		return abreviation;
	}
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
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
		result = prime * result + ((abreviation == null) ? 0 : abreviation.hashCode());
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
		if (abreviation == null) {
			if (other.abreviation != null)
				return false;
		} else if (!abreviation.equals(other.abreviation))
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
		return "Filiere [" + (id != null ? "id=" + id + ", " : "") 
				+ (code != null ? "code=" + code + ", " : "") + (nom != null ? "nom=" + nom + ", " : "")
				+ (abreviation != null ? "abreviation=" + abreviation + ", " : "")
				+ (inscriptions != null ? "inscriptions=" + inscriptions : "") + "]";
	}
	public Filiere(Long id, Long annee, String designation, String code, String nom, String abreviation,
			List<Inscription> inscriptions) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.abreviation = abreviation;
		this.inscriptions = inscriptions;
	}
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
