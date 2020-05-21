package com.examplegestionDesNotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Departement;
import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.dao.EnseignantDao;
import com.examplegestionDesNotes.service.facade.DeparetementService;
import com.examplegestionDesNotes.service.facade.EnsiegnantService;
import com.examplegestionDesNotes.service.utils.PasswordUtils;

@Service
public class EnseignantImpl implements EnsiegnantService {
@Autowired
public EnseignantDao enseignantDao;
@Autowired
public DeparetementService deparetementService;




@Override
public int save(Enseignant enseignant) {
	 String salt = PasswordUtils.getSalt(30);
	 String Password = PasswordUtils.generateSecurePassword(enseignant.getMotDePasse(), salt);
	Departement departement= deparetementService.findByNom(enseignant.getDepartement().getNom());
	if(findByNom(enseignant.getNom())!=null)
		return -1;
	else {
		if(departement==null) {
			return -2;
		}else {
			enseignant.setSalt(salt);
			enseignant.setDepartement(departement);
			enseignant.setMotDePasse(Password);
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

@Override
public Enseignant findByLogin(String login) {
	return enseignantDao.findByLogin(login);
}

@Override
public int findByLoginAndMotDePasse(String login, String motDePasse) {
	Enseignant enseignant=findByLogin(login);
	if(enseignant==null)
		return -1;
	else {
		 String salt = enseignant.getSalt();
		 boolean passwordMatch = PasswordUtils.verifyUserPassword(motDePasse, enseignant.getMotDePasse(), salt);
		if(passwordMatch) {
		return 1;
	}else {
		return -2;
	}
	}
}




}
