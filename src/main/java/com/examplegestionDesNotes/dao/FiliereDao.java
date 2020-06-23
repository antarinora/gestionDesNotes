package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Filiere;

@Repository
public interface FiliereDao extends JpaRepository<Filiere, Long> {
	public Filiere findByNom(String nom);
	public void deleteByCode(String code);
	public void deleteByNom(String nom);
	public Filiere findByCode(String code);
	@Query(value = "SELECT COUNT(*) from filiere",nativeQuery = true)
	public int filiereTotale();


}
