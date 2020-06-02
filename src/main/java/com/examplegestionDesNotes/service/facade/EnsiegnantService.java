package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Enseignant;

public interface EnsiegnantService {
	public int save(Enseignant enseignant);
	public List<Enseignant> findAll();
	public Enseignant findByLogin(String login);
	public Enseignant findByNom(String nom);
	public int findByLoginAndMotDePasse(String login,String motDePasse );
	public int updateLogin(String login1,String motDePasse,String login2);
	public int updateMotDePass(String login,String motDePasse,String motDePasse2);
}
