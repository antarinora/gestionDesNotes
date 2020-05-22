package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.dao.NoteDao;
import com.examplegestionDesNotes.service.facade.NoteService;

@Service
public class NoteImpl implements NoteService {
	@Autowired
	public NoteDao noteDao;

	@Override
	public void save(Note note) {
		noteDao.save(note);
		
	}

	@Override
	public List<Note> findAll() {
		
		return noteDao.findAll();
	}

	@Override
	public Note findByEtidaintCneAndModuleNom(String cne, String nom) {
		List<Note>notes=findAll();
		for(Note note:notes) {
			if(note.getEtudiant().getCne().equals(cne) && note.getModule().getNom().equals(nom))
				return note;
		}
		return null;
	}
	

}
