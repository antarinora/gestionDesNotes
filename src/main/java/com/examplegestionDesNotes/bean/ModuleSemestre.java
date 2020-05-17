package com.examplegestionDesNotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ModuleSemestre {
@ GeneratedValue(strategy = GenerationType.AUTO)
@Id
private Long id;
@ManyToOne
private Module module;
@ManyToOne
private Semestre semestre;
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
public Semestre getSemestre() {
	return semestre;
}
public void setSemestre(Semestre semestre) {
	this.semestre = semestre;
}
@Override
public String toString() {
	return "ModuleSemestre [id=" + id + ", module=" + module + ", semestre=" + semestre + "]";
}
public ModuleSemestre(Long id, Module module, Semestre semestre) {
	super();
	this.id = id;
	
	this.module = module;
	this.semestre = semestre;
}
public ModuleSemestre() {
	super();
	// TODO Auto-generated constructor stub
}


}
