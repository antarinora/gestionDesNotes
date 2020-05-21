package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.dao.FiliereDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;

@Service
public class FiliereImpl implements FiliereService {
@Autowired
public FiliereDao filiereDao;
@Autowired EtudiantService etudiantService;

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
	for(Inscription inscription:etudiant.getInscriptions()) {
		filieres.add(inscription.getFiliere());
	}
	return filieres;
}

}
