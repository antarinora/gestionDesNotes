package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.ModuleFiliere;

@Repository
public interface ModuleFiliereDao extends JpaRepository<ModuleFiliere, Long> {

}
