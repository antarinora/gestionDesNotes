package com.examplegestionDesNotes.bean;



import java.awt.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etudiant {
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Id
 private Long id;
 private int cne;
 private String nom;
 private String prenom;

 

}
