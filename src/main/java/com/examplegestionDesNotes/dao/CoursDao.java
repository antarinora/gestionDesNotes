package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Cours;

@Repository
public interface CoursDao extends JpaRepository<Cours, Long> {
public Cours findByEnseignantCinAndModuleNom(String cin,String nom);
@Modifying
@Query(value="DELETE FROM cours where cours.module = :id",nativeQuery = true)
public void deleteByModule(@Param(value = "id") Long id);
}
