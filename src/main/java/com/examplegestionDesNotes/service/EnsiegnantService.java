package com.examplegestionDesNotes.service;

import java.util.List;

import com.examplegestionDesNotes.bean.Enseignant;

public interface EnsiegnantService {
	public int save(Enseignant enseignant);
	public Enseignant findByNom(String nom);
	public List<Enseignant> findAll();
}
