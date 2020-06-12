package com.examplegestionDesNotes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

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
	if(findByLogin(enseignant.getLogin())!=null)
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
	}else if(enseignant.getNombreEssai() >2) {
		enseignant.setStatut(false);
		enseignantDao.save(enseignant);
		return -3;
	}else {
		enseignant.setNombreEssai(enseignant.getNombreEssai()+1);
		enseignantDao.save(enseignant);
		return -2;	
	}
		
	}
}


@Override
public int updateLogin(String login1, String motDePasse, String login2) {
	if(findByLoginAndMotDePasse(login1, motDePasse)==-1)
		return -1;
	else if(findByLoginAndMotDePasse(login1, motDePasse)==-2) {
		return -2;
	}else {
		Enseignant enseignant=findByLogin(login1);
		enseignant.setLogin(login2);
		enseignantDao.save(enseignant);
		return 1;
	}
}


@Override
public int updateMotDePass(String login, String motDePasse, String motDePasse2) {
	if(findByLoginAndMotDePasse(login, motDePasse)==-1)
		return -1;
	else if(findByLoginAndMotDePasse(login, motDePasse)==-2) {
		return -2;
	}else {
		Enseignant enseignant=findByLogin(login);
		String salt = enseignant.getSalt();
		 String Password = PasswordUtils.generateSecurePassword(motDePasse2, salt);
		 enseignant.setMotDePasse(Password);
      enseignantDao.save(enseignant);
      return 1;
		
	}
}


@Override
@Transactional
public int deleteByLogin(String login) {
	Enseignant enseignant=findByLogin(login);
	if(enseignant==null) {
		return -1;
	}else {
		enseignantDao.deleteByLogin(login);
		return 1;
	}
}


@Override
public int updateStatut(Enseignant enseignant, boolean statut) {
	Enseignant enseignantFounded=findByLogin(enseignant.getLogin());
	if(enseignantFounded==null) {
		return -1;
	}else {
		if(statut==true) {
		enseignantFounded.setNombreEssai(0);
		enseignantFounded.setStatut(statut);
		enseignantDao.save(enseignantFounded);
		return 1;
		}else {
			enseignantFounded.setNombreEssai(3);
			enseignantFounded.setStatut(statut);
			enseignantDao.save(enseignantFounded);
			return 2;
		}
	}
}




}
