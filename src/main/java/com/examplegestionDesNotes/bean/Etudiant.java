package com.examplegestionDesNotes.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etudiant {
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Id
 private Long id;
 private int cne;
 private String cin;
 private String nom;
 private String prenom;
 @OneToMany(mappedBy = "etudiant")
 private List<Inscription> inscriptions;
 

}
