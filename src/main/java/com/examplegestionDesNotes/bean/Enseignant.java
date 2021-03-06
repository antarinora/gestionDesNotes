package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Enseignant {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private String login;
	private String motDePasse;
	private boolean statut = true;
	private int nombreEssais = 0;
	@ManyToOne
	private Departement departement;
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "enseignant")
	private List<Cours> seances;
	private String salt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public int getNombreEssais() {
		return nombreEssais;
	}
	public void setNombreEssais(int nombreEssais) {
		this.nombreEssais = nombreEssais;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public List<Cours> getSeances() {
		return seances;
	}
	public void setSeances(List<Cours> seances) {
		this.seances = seances;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((departement == null) ? 0 : departement.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + nombreEssais;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((seances == null) ? 0 : seances.hashCode());
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
		Enseignant other = (Enseignant) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (nombreEssais != other.nombreEssais)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (seances == null) {
			if (other.seances != null)
				return false;
		} else if (!seances.equals(other.seances))
			return false;
		if (statut != other.statut)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Enseignant [" + (id != null ? "id=" + id + ", " : "") + (cin != null ? "cin=" + cin + ", " : "")
				+ (nom != null ? "nom=" + nom + ", " : "") + (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (login != null ? "login=" + login + ", " : "")
				+ (motDePasse != null ? "motDePasse=" + motDePasse + ", " : "") + "statut=" + statut + ", nombreEssais="
				+ nombreEssais + ", " + (departement != null ? "departement=" + departement + ", " : "")
				+ (seances != null ? "seances=" + seances + ", " : "") + (salt != null ? "salt=" + salt : "") + "]";
	}
	public Enseignant(Long id, String cin, String nom, String prenom, String login, String motDePasse, boolean statut,
			int nombreEssais, Departement departement, List<Cours> seances, String salt) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.statut = statut;
		this.nombreEssais = nombreEssais;
		this.departement = departement;
		this.seances = seances;
		this.salt = salt;
	}
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
