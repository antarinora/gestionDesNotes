package com.examplegestionDesNotes.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Etudiant {
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Id
 private Long id;
 private String cne;
 private String cin;
 private String nom;
 private String prenom;
 private String email;
 private Date dateDeNaissance;
 @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
 private Long codeApogee;
 private Date dateNaissance;
@OneToMany(mappedBy = "etudiant")
 private List<Inscription> inscriptions;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCne() {
	return cne;
}
public void setCne(String cne) {
	this.cne = cne;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public Long getCodeApogee() {
	return codeApogee;
}
public void setCodeApogee(Long codeApogee) {
	this.codeApogee = codeApogee;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
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
	result = prime * result + ((cin == null) ? 0 : cin.hashCode());
	result = prime * result + ((cne == null) ? 0 : cne.hashCode());
	result = prime * result + ((codeApogee == null) ? 0 : codeApogee.hashCode());
	result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
	Etudiant other = (Etudiant) obj;
	if (cin == null) {
		if (other.cin != null)
			return false;
	} else if (!cin.equals(other.cin))
		return false;
	if (cne == null) {
		if (other.cne != null)
			return false;
	} else if (!cne.equals(other.cne))
		return false;
	if (codeApogee == null) {
		if (other.codeApogee != null)
			return false;
	} else if (!codeApogee.equals(other.codeApogee))
		return false;
	if (dateNaissance == null) {
		if (other.dateNaissance != null)
			return false;
	} else if (!dateNaissance.equals(other.dateNaissance))
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
	if (prenom == null) {
		if (other.prenom != null)
			return false;
	} else if (!prenom.equals(other.prenom))
		return false;
	return true;
}
@Override
public String toString() {
	return "Etudiant [id=" + id + ", cne=" + cne + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom
			+ ", codeApogee=" + codeApogee + ", dateNaissance=" + dateNaissance + ", inscriptions=" + inscriptions
			+ "]";
}
public Etudiant(Long id, String cne, String cin, String nom, String prenom, Long codeApogee, Date dateNaissance,
		List<Inscription> inscriptions) {
	super();
	this.id = id;
	this.cne = cne;
	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
	this.codeApogee = codeApogee;
	this.dateNaissance = dateNaissance;
	this.inscriptions = inscriptions;
}
public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}


}
