package com.examplegestionDesNotes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.dao.InscritionDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.InscriptionService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.NoteService;

@Service
public class InscriptionImpl implements InscriptionService {
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
	@Override
	public int save(Inscription inscription) {
		Etudiant etudiant=etudiantService.findByCne(inscription.getEtudiant().getCne());
		Filiere filiere=filiereService.findByNom(inscription.getFiliere().getNom());
		if(etudiant==null) {
			etudiantService.save(inscription.getEtudiant());
			inscription.setEtudiant(inscription.getEtudiant());
			inscription.setFiliere(filiere);
			inscritionDao.save(inscription);
			return 2;
		}else if(filiere==null) {
			return -1;
		}else {
			inscription.setEtudiant(etudiant);
			inscription.setFiliere(filiere);
			inscritionDao.save(inscription);	
			return 1;
		}
	}

	

}
