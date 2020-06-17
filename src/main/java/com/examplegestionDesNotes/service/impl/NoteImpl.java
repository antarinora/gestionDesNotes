package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.dao.NoteDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.InscriptionService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.NoteService;
import com.examplegestionDesNotes.service.utils.AnnéeUniversitaire;

@Service
public class NoteImpl implements NoteService {
	@Autowired
	public NoteDao noteDao;
	@Autowired
	public ModuleService moduleService;
	@Autowired
	public EtudiantService etudiantService;
	@Autowired
	public FiliereService filiereService; 
	@Autowired
	public InscriptionService inscriptionService;

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
		String annee=AnnéeUniversitaire.formater();
		for(Note note:notes) {
			if(note.getEtudiant().getCne().equals(cne) && note.getModule().getNom().equals(nom) && note.getAnnee().equals(annee))
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

	@Override
	public List<Note> findByModuleNomNonNull(String nom) {
		List<Note> notes=findByModuleNom(nom);
		List<Note>notes1=new ArrayList<Note>();
		for( Note note:notes) {
			if(note.getTotal()!=0 && note.getResultat()!=null ) {
				notes1.add(note);
			}
		}
		
		return notes1;
	}

	@Override
	public List<Note> findByModuleNom(String nom) {
		// TODO Auto-generated method stub
		return noteDao.findByModuleNom(nom);
	}

	@Override
	public int saveDeux(Note note, String nom) {
		Etudiant etudiant=etudiantService.findByCne(note.getEtudiant().getCne());
		Module module= moduleService.findByNom(note.getModule().getNom());
		Inscription inscription=new Inscription();
		Filiere filiere= filiereService.findByNom(nom);
		if(etudiant==null) {
			etudiantService.save(note.getEtudiant());
			note.setEtudiant(note.getEtudiant());
			note.setModule(module);
			inscription.setEtudiant(note.getEtudiant());
			inscription.setFiliere(filiere);
			noteDao.save(note);
			inscriptionService.save(inscription);
			return 2;
			}else if(module==null) {
				return -1;
			}else if(filiere== null) {
				return -2;
			}else {
				note.setEtudiant(etudiant);
				note.setModule(module);
				inscription.setEtudiant(etudiant);
				inscription.setFiliere(filiere);
				noteDao.save(note);
				inscriptionService.save(inscription);
				return 1;
			}
		}

	@Override
	public int updateTableNote(Note note) {
		Note noteFounded=noteDao.findById(note.getId()).get();
		if(noteFounded == null) {
			return -1;
		}else {
			noteFounded.getEtudiant().setCin(note.getEtudiant().getCin());
			noteFounded.getEtudiant().setCne(note.getEtudiant().getCne());
			noteFounded.getEtudiant().setCodeApogee(note.getEtudiant().getCodeApogee());
			noteFounded.getEtudiant().setNom(note.getEtudiant().getNom());
			noteFounded.getEtudiant().setPrenom(note.getEtudiant().getPrenom());
			noteFounded.getEtudiant().setDateNaissance(note.getEtudiant().getDateNaissance());
			noteFounded.setModule(note.getModule());
			noteFounded.setAnnee(note.getAnnee());
			noteFounded.setPremierControle(note.getPremierControle());
			noteFounded.setTp(note.getTp());
			noteFounded.setTd(note.getTd());
			noteFounded.setTotal(note.getTotal());
			noteFounded.setResultat(note.getResultat());
			noteDao.save(noteFounded);
			return 1;
		}
	}

	@Override
	public int update(Note note) {
	if(note==null) {
		return 1;
	}else {
		note.setPremierControle(0);
		note.setDeuxiemeControle(0);
        note.setTp(0);
		note.setTd(0);
		note.setTotal(0);
		note.setResultat(null);
		noteDao.save(note);
       return 1;
		
	}
	}

	@Override
	@Transactional
	public int deleteByEtudiantCne(String cne) {
		Etudiant etudiant=etudiantService.findByCne(cne);
		if(etudiant==null) {
			return -1;
		}else {
			noteDao.deleteByEtudiantCne(etudiant.getId());
			inscriptionService.deleteByEtudiantCne(cne);
			etudiantService.deleteByCne(cne);
			return 1;
	}
	}

	
}
