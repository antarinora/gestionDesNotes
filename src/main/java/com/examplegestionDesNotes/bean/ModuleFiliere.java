package com.examplegestionDesNotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ModuleFiliere {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private Long id;

@ManyToOne
private Module module;
@ManyToOne
private Filiere filiere;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public Module getModule() {
	return module;
}
public void setModule(Module module) {
	this.module = module;
}
public Filiere getFiliere() {
	return filiere;
}
public void setFiliere(Filiere filiere) {
	this.filiere = filiere;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((filiere == null) ? 0 : filiere.hashCode());
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
	ModuleFiliere other = (ModuleFiliere) obj;
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
	if (module == null) {
		if (other.module != null)
			return false;
	} else if (!module.equals(other.module))
		return false;
	return true;
}


@Override
public String toString() {
	return "ModuleFiliere [id=" + id + ", module=" + module + ", filiere=" + filiere + "]";
}
public ModuleFiliere(Long id, Module module, Filiere filiere) {
	super();
	this.id = id;
	this.module = module;
	this.filiere = filiere;
}
public ModuleFiliere() {
	super();
	// TODO Auto-generated constructor stub
}

}
