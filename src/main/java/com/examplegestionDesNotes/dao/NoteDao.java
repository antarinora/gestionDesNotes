package com.examplegestionDesNotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Note;

@Repository
public interface NoteDao extends JpaRepository<Note, Long> {
	 public Note findByModuleNomAndEtudiantCodeApogee(String nom,Long codeApogee);
     public List<Note> findByModuleNom(String nom);
     @Modifying
 	@Query(value="DELETE FROM note where note.etudiant = :id",nativeQuery = true)
 	public void deleteByEtudiantCne(@Param(value = "id") Long id);


}
