package com.examplegestionDesNotes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.dao.InscritionDao;
import com.examplegestionDesNotes.dao.NoteDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.InscriptionService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.NoteService;

@Service
public  class InscriptionImpl implements InscriptionService {
	@Autowired
	public InscritionDao inscritionDao;
	@Autowired
	public EtudiantService etudiantService;
	@Autowired
	public FiliereService filiereService;
	@Autowired 
	public ModuleService moduleService;
  @Autowired
 public NoteService noteService;
  @Autowired
  public NoteDao noteDao;
	@Override
	public int save(Inscription inscription) {
		Etudiant etudiant=etudiantService.findByCne(inscription.getEtudiant().getCne());
		Filiere filiere=filiereService.findByNom(inscription.getFiliere().getNom());
		if(etudiant==null) {
			etudiantService.save(inscription.getEtudiant());
			inscription.setEtudiant(inscription.getEtudiant());
			inscription.setFiliere(filiere);
			inscription.setAnnee(inscription.getAnnee());
			inscritionDao.save(inscription);
			return 2;
		}else if(filiere==null) {
			return -1;
		}else {
			inscription.setEtudiant(etudiant);
			inscription.setFiliere(filiere);
			inscription.setAnnee(inscription.getAnnee());
			inscritionDao.save(inscription);	
			return 1;
		}
	}
	
	@Override
	public int updateInscription(Inscription inscription) {
		Inscription inscriptionFounded=inscritionDao.findById(inscription.getId()).get();
		if(inscriptionFounded==null) {
			return -1;
		}else {
			inscriptionFounded.setEtudiant(inscription.getEtudiant());
			inscriptionFounded.setFiliere(inscription.getFiliere());
			inscriptionFounded.setAnnee(inscription.getAnnee());
			inscritionDao.save(inscriptionFounded);
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
			inscritionDao.deleteByEtudiantCne(etudiant.getId());
			return 1;
	}
	}

	@Override
	public int saveInsc(Inscription inscription) {
		Filiere filiere=filiereService.findByCode(inscription.getFiliere().getCode());
		Etudiant etudiant=etudiantService.findByCne(inscription.getEtudiant().getCne());
		if(filiere == null) {
			return -1;
		}else if(etudiant == null) {
			List<Module> modules = moduleService.findByFiliereCode(filiere.getCode());
			etudiantService.save(inscription.getEtudiant());
			inscription.setEtudiant(inscription.getEtudiant());
			inscription.setFiliere(filiere);
			inscritionDao.save(inscription);
			for(Module mo: modules) {
				Note note=new Note();
				note.setEtudiant(inscription.getEtudiant());
				note.setModule(mo);
				note.setAnnee(inscription.getAnnee());
				noteService.save(note);
				}
			return 2;
		}else {
			List<Module> modules = moduleService.findByFiliereCode(filiere.getCode());
			inscription.setEtudiant(etudiant);
			inscription.setFiliere(filiere);
			inscritionDao.save(inscription);	
			for(Module mo:modules) {
				Note note=new Note();
				note.setEtudiant(etudiant);
				note.setModule(mo);
				note.setAnnee(inscription.getAnnee());
				noteService.save(note);
				}
			return 1;
		}
	}

	@Override
	public List<Inscription> findAll() {
		return inscritionDao.findAll();
	}

	

	

}

