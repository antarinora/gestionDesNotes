package com.examplegestionDesNotes.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String cin;
	private String nom;
	private String prénom;
	private String login;
	private String motDePasse;
	private String poste;
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
	public String getPrénom() {
		return prénom;
	}
	public void setPrénom(String prénom) {
		this.prénom = prénom;
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
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((poste == null) ? 0 : poste.hashCode());
		result = prime * result + ((prénom == null) ? 0 : prénom.hashCode());
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
		Admin other = (Admin) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
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
		if (poste == null) {
			if (other.poste != null)
				return false;
		} else if (!poste.equals(other.poste))
			return false;
		if (prénom == null) {
			if (other.prénom != null)
				return false;
		} else if (!prénom.equals(other.prénom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prénom=" + prénom + ", login=" + login
				+ ", motDePasse=" + motDePasse + ", poste=" + poste + "]";
	}
	public Admin(Long id, String cin, String nom, String prénom, String login, String motDePasse, String poste) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prénom = prénom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.poste = poste;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
