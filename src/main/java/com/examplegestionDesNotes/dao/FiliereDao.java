package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Filiere;

@Repository
public interface FiliereDao extends JpaRepository<Filiere, Long> {
	public Filiere findByNom(String nom);
	public void deleteByCode(String code);
	public Filiere findByCode(String code);

}
