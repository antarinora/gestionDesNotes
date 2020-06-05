package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Module;

@Repository
public interface ModuleDao extends JpaRepository<Module, Long>{
public Module findByNom(String nom);
@Modifying
@Query(value="DELETE FROM module where module.id = :id",nativeQuery = true)
public void deleteByModule(@Param(value = "id") Long id);
}
