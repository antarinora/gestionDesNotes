package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.dao.FiliereDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.InscriptionService;
import com.examplegestionDesNotes.service.utils.AnnéeUniversitaire;

@Service
public class FiliereImpl implements FiliereService {
@Autowired
public FiliereDao filiereDao;
@Autowired 
public EtudiantService etudiantService;
@Autowired
public InscriptionService inscriptionService;

@Override
public int save(Filiere filiere) {
	if(findByNom(filiere.getNom())!=null) {
		return -1;
	}else {
		filiereDao.save(filiere);
		return 1;
	}
}

@Override
public List<Filiere> findAll() {
	return filiereDao.findAll();
}

@Override
public Filiere findByNom(String nom) {
	return filiereDao.findByNom(nom);
}

@Override
public List<Filiere> findByEtudiantCne(String cne) {
	List<Filiere> filieres= new ArrayList<Filiere>();
	Etudiant etudiant=etudiantService.findByCne(cne);
	String annee=AnnéeUniversitaire.formater();
     for(Inscription inscription:etudiant.getInscriptions()) {
		if(inscription.getAnnee().equals(annee)) {
			filieres.add(inscription.getFiliere());
		}
		
	}
	return filieres;
}

@Transactional
@Override
public int deleteByNom(String nom) {
	if (findByNom(nom) == null)
		return -1;
	else {
		filiereDao.deleteByNom(nom);
		return 1;
	}
}

@Override
public Filiere findByCode(String code) {
	return filiereDao.findByCode(code);
}

}
