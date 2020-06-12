package com.examplegestionDesNotes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inscription {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private Long id;

private String annee;
@ManyToOne
private Etudiant etudiant;
@ManyToOne
private Filiere filiere;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public Etudiant getEtudiant() {
	return etudiant;
}
public void setEtudiant(Etudiant etudiant) {
	this.etudiant = etudiant;
}
public Filiere getFiliere() {
	return filiere;
}
public void setFiliere(Filiere filiere) {
	this.filiere = filiere;
}

public String getAnnee() {
	return annee;
}
public void setAnnee(String annee) {
	this.annee = annee;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((annee == null) ? 0 : annee.hashCode());
	result = prime * result + ((etudiant == null) ? 0 : etudiant.hashCode());
	result = prime * result + ((filiere == null) ? 0 : filiere.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	Inscription other = (Inscription) obj;
	if (annee == null) {
		if (other.annee != null)
			return false;
	} else if (!annee.equals(other.annee))
		return false;
	if (etudiant == null) {
		if (other.etudiant != null)
			return false;
	} else if (!etudiant.equals(other.etudiant))
		return false;
	if (filiere == null) {
		if (other.filiere != null)
			return false;
	} else if (!filiere.equals(other.filiere))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public String toString() {
	return "Inscription [id=" + id + ", annee=" + annee + ", etudiant=" + etudiant + ", filiere=" + filiere + "]";
}
public Inscription(Long id, String annee, Etudiant etudiant, Filiere filiere) {
	super();
	this.id = id;
	this.annee = annee;
	this.etudiant = etudiant;
	this.filiere = filiere;
}

public Inscription() {
	super();
	// TODO Auto-generated constructor stub
}


}
