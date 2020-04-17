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
private Date annee;
@ManyToOne
private Module module;
@ManyToOne
private Filiere filiere;
}
