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
 @OneToMany(mappedBy = "etudiant")
 private List<Inscription> inscriptions;

 

}
