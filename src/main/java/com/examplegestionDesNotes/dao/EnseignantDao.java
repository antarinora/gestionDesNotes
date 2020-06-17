package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Enseignant;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant, Long> {
public Enseignant findByNom(String nom);
public Enseignant findByCin(String cin);
public Enseignant findByLogin(String login);
public void deleteByCin(String cin);
@Query(value = "SELECT COUNT(*) from enseignant",nativeQuery = true)
public int enseignantTotale();

}
