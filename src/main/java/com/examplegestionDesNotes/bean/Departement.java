package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Departement {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private Long id;
private String nom;
private String code;
private String responsable;
@OneToMany(mappedBy = "departement")
@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
private List<Enseignant>enseignants;
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
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getResponsable() {
	return responsable;
}
public void setResponsable(String responsable) {
	this.responsable = responsable;
}
public List<Enseignant> getEnseignants() {
	return enseignants;
}
public void setEnseignants(List<Enseignant> enseignants) {
	this.enseignants = enseignants;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + ((enseignants == null) ? 0 : enseignants.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((responsable == null) ? 0 : responsable.hashCode());
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
	Departement other = (Departement) obj;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	if (enseignants == null) {
		if (other.enseignants != null)
			return false;
	} else if (!enseignants.equals(other.enseignants))
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
	if (responsable == null) {
		if (other.responsable != null)
			return false;
	} else if (!responsable.equals(other.responsable))
		return false;
	return true;
}
@Override
public String toString() {
	return "Departement [id=" + id + ", nom=" + nom + ", code=" + code + ", responsable=" + responsable
			+ ", enseignants=" + enseignants + "]";
}
public Departement(Long id, String nom, String code, String responsable, List<Enseignant> enseignants) {
	super();
	this.id = id;
	this.nom = nom;
	this.code = code;
	this.responsable = responsable;
	this.enseignants = enseignants;
}
public Departement() {
	super();
	// TODO Auto-generated constructor stub
}

}
