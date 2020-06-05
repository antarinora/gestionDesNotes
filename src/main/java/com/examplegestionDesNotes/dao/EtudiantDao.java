package com.examplegestionDesNotes.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Etudiant;
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
public Etudiant findByCne(String cne);
public Etudiant findByCodeApogee(String codeApogee);
@Modifying
@Query(value="DELETE FROM etudiant where etudiant.id = :id",nativeQuery = true)
public void deleteBycne(@Param(value = "id") Long id);

}
