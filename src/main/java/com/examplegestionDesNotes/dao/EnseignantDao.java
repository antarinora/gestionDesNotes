package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Enseignant;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant, Long> {
public Enseignant findByNom(String nom);
public Enseignant findByLogin(String login);
}
