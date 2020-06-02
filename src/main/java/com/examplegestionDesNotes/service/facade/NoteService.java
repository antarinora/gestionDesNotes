package com.examplegestionDesNotes.service.facade;

import java.util.List;
import com.examplegestionDesNotes.bean.Note;

public interface NoteService {
 public int save(Note note);
 public List<Note>findAll();
 public Note findByEtidaintCneAndModuleNom(String cne,String nom);
 public int updateNote(Note note);
 public Note findByModuleNomAndEtudiantCodeApogee(String nom,Long codeApogee);
 public List<Note> findByModuleNom(String nom);
 public List<Note> findByModuleNomNonNull(String nom);
 public int saveDeux(Note note,String nom);
}
