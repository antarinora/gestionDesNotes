package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Departement;

@Repository
public interface DepartemantDao extends JpaRepository<Departement, Long> {
public Departement findByNom(String nom);
public Departement findByCode(String code);
public void deleteByCode(String code);
@Query(value = "SELECT COUNT(*) from departement",nativeQuery = true)
public int departementTotale();
}
