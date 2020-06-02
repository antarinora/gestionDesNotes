package com.examplegestionDesNotes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.dao.InscriptionDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.InscriptionService;

@Service
public class InscriptionImpl implements InscriptionService{
	@Autowired
	private InscriptionDao inscriptionDao;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private FiliereService filiereService;

	@Override
	public int save(Inscription inscription) {
		Etudiant etudiant =etudiantService.findByCne(inscription.getEtudiant().getCne());
		Filiere filiere =filiereService.findByNom(inscription.getFiliere().getNom());

		if(etudiant==null) {
			etudiantService.save(inscription.getEtudiant());
			inscription.setEtudiant(inscription.getEtudiant());
			inscription.setFiliere(filiere);
			inscriptionDao.save(inscription);
			return 2;
		}else if(filiere==null) {
			return -2;
		}else {
		inscription.setEtudiant(etudiant);
		inscription.setFiliere(filiere);
		inscriptionDao.save(inscription);
		return 1;
		}
	}

	}
	


