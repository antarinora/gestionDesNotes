package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Note;

@Repository
public interface NoteDao extends JpaRepository<Note, Long> {
	 public Note findByModuleNomAndEtudiantCodeApogee(String nom,Long codeApogee);


}
