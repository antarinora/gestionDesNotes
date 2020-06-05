package com.examplegestionDesNotes.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.ModuleFiliere;

@Repository
public interface ModuleFiliereDao extends JpaRepository<ModuleFiliere, Long> {
	@Modifying
	@Query(value="DELETE FROM module_filiere where module_filiere.module = :id",nativeQuery = true)
    public void deleteByModule(@Param(value = "id") Long id);
}
