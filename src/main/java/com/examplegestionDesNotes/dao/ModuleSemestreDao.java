package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.ModuleSemestre;

@Repository
public interface ModuleSemestreDao extends JpaRepository<ModuleSemestre, Long> {

}
