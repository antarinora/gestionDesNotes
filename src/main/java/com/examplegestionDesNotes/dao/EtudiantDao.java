package com.examplegestionDesNotes.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Etudiant;
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
public Etudiant findByCne(String cne);
public Etudiant findByCodeApogee(String codeApogee);
}
