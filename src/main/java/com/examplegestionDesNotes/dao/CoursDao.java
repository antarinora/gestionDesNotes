package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Cours;

@Repository
public interface CoursDao extends JpaRepository<Cours, Long> {
public Cours findByEnseignantCinAndModuleNom(String cin,String nom);
}
