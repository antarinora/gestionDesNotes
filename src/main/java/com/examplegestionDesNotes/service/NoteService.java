package com.examplegestionDesNotes.service;

import java.util.List;

import com.examplegestionDesNotes.bean.Note;

public interface NoteService {
 public void save(Note note);
 public List<Note>findAll();
 public Note findByEtidaintCneAndModuleNom(String cne,String nom);

}
