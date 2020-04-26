package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Module {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nom;
	private String code;
	private String abréviation;
	@OneToMany(mappedBy = "module")
	private List<Cours> seances;
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
	public String getAbréviation() {
		return abréviation;
	}
	public void setAbréviation(String abréviation) {
		this.abréviation = abréviation;
	}
	public List<Cours> getSeances() {
		return seances;
	}
	public void setSeances(List<Cours> seances) {
		this.seances = seances;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abréviation == null) ? 0 : abréviation.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((seances == null) ? 0 : seances.hashCode());
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
		Module other = (Module) obj;
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
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (seances == null) {
			if (other.seances != null)
				return false;
		} else if (!seances.equals(other.seances))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", nom=" + nom + ", code=" + code + ", abréviation=" + abréviation + ", seances="
				+ seances + "]";
	}
	public Module(Long id, String nom, String code, String abréviation, List<Cours> seances) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.abréviation = abréviation;
		this.seances = seances;
	}
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
