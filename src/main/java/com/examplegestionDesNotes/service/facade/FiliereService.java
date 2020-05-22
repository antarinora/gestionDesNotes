package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Filiere;

public interface FiliereService {
	public int save(Filiere filiere);
	public List<Filiere> findAll();
	public Filiere findByNom(String nom);
	public List<Filiere> findByEtudiantCne(String cne);
	public int deleteByNom(String nom);
	public int updateFiliere(Filiere filiere);
}
