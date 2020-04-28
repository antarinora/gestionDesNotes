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
private int promotion;
private int annee;
@ManyToOne
private Etudiant etudiant;
@ManyToOne
private Filiere filiere; 

}
