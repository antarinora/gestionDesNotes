package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.ModuleSemestre;

@Repository
public interface ModuleSemestreDao extends JpaRepository<ModuleSemestre, Long> {
	@Modifying
	@Query(value="DELETE FROM module_semestre where module_semestre.module = :id",nativeQuery = true)
    public void deleteByModule(@Param(value = "id") Long id);
}
