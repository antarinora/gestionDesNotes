package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.dao.NoteDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.NoteService;

@Service
public class NoteImpl implements NoteService {
	@Autowired
	public NoteDao noteDao;
	@Autowired
	public ModuleService moduleService;
	@Autowired
	public EtudiantService etudiantService;

	@Override
	public int save(Note note) {
		Etudiant etudiant=etudiantService.findByCne(note.getEtudiant().getCne());
		Module module=moduleService.findByNom(note.getModule().getNom());
		if(etudiant==null) {
			etudiantService.save(note.getEtudiant());
			note.setEtudiant(note.getEtudiant());
			note.setModule(module);
			noteDao.save(note);
			return 2;
		}else if(module==null) {
			return -1;
		}else {
			note.setEtudiant(etudiant);
			note.setModule(module);
			noteDao.save(note);	
			return 1;
		}
		
		
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

	@Override
	public int updateNote(Note note) {
		Note note2=findByModuleNomAndEtudiantCodeApogee(note.getModule().getNom(), note.getEtudiant().getCodeApogee());
	if(note2==null) {
		return -1;
	}else {
		note2.setPremierControle(note.getPremierControle());
		note2.setDeuxiemeControle(note.getDeuxiemeControle());
		note2.setTd(note.getTd());
		note2.setTp(note.getTp());
		note2.setResultat(note.getResultat());
		note2.setTotal(note.getTotal());
		save(note2);
		return 1;
	}
	}

	@Override
	public Note findByModuleNomAndEtudiantCodeApogee(String nom, Long codeApogee) {
		return noteDao.findByModuleNomAndEtudiantCodeApogee(nom, codeApogee);
	
	}
}
