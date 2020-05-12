package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Module;

@Repository
public interface ModuleDao extends JpaRepository<Module, Long>{
public Module findByNom(String nom);
}
