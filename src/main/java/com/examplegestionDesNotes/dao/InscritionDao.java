package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Inscription;

@Repository
public interface InscritionDao extends JpaRepository<Inscription, Long> {
	@Modifying
	@Query(value="DELETE FROM inscription where inscription.etudiant = :id",nativeQuery = true)
	public void deleteByEtudiantCne(@Param(value = "id") Long id);

}
