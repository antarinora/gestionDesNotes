package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Semestre;
@Repository
public interface SemestreDao extends JpaRepository<Semestre, Long> {
public Semestre findByNom(String nom);
public void deleteByNom(String nom);
@Query(value = "SELECT COUNT(*) from semestre",nativeQuery = true)
public int semestreTotale();

}
