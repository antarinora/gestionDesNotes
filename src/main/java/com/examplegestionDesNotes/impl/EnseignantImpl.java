package com.examplegestionDesNotes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Departement;
import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.dao.EnseignantDao;
import com.examplegestionDesNotes.service.DeparetementService;
import com.examplegestionDesNotes.service.EnsiegnantService;

@Service
public class EnseignantImpl implements EnsiegnantService {
@Autowired
public EnseignantDao enseignantDao;
@Autowired
public DeparetementService deparetementService;

@Override
public int save(Enseignant enseignant) {
	Departement departement= deparetementService.findByNom(enseignant.getDepartement().getNom());
	if(findByNom(enseignant.getNom())!=null)
		return -1;
	else {
		if(departement==null) {
			return -2;
		}else {
			enseignant.setDepartement(departement);
			enseignantDao.save(enseignant);
			return 1;
		}
		
	}
}

@Override
public Enseignant findByNom(String nom) {
	return enseignantDao.findByNom(nom);
}

@Override
public List<Enseignant> findAll() {
	
	return enseignantDao.findAll();
}


}
