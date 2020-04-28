package com.examplegestionDesNotes.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class ModuleSemestre {
@ GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private int annee;
@ManyToOne
private Module module;
@ManyToOne
private Semestre semestre;
}
