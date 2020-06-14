package com.examplegestionDesNotes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Departement;
import com.examplegestionDesNotes.bean.Enseignant;
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
	Departement departement= deparetementService.findByCode(enseignant.getDepartement().getCode());
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
public Enseignant findByNom(String nom) {
	return enseignantDao.findByNom(nom);
}
@Override
public Enseignant findByCin(String cin) {
	return enseignantDao.findByCin(cin);
}
@Override
public int findByLoginAndMotDePasse(String login, String motDePasse) {
	Enseignant enseignant=findByLogin(login);
	if(enseignant==null)
		return -1;
	    else {
		 String salt = enseignant.getSalt();
		 boolean passwordMatch = PasswordUtils.verifyUserPassword(motDePasse, enseignant.getMotDePasse(), salt);
		if(passwordMatch && enseignant.getNombreEssais()<3) {
		return 1;
	}else if(enseignant.getNombreEssais() >2) {
		enseignant.setStatut(false);
		enseignantDao.save(enseignant);
		return -3;
	}else {
		enseignant.setNombreEssais(enseignant.getNombreEssais()+1);
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
public int updateMotDePass(String login,String motDePasse,String motDePasse2,String motDePasse3){
	if(findByLoginAndMotDePasse(login, motDePasse)==-1)
		return -1;
	else if(findByLoginAndMotDePasse(login, motDePasse)==-2) {
		return -2;
	}else if(!motDePasse2.equals(motDePasse3)) {
		return -3;
	}
	else {
		Enseignant enseignant=findByLogin(login);
		String salt = enseignant.getSalt();
		 String Password = PasswordUtils.generateSecurePassword(motDePasse2, salt);
		 enseignant.setMotDePasse(Password);
      enseignantDao.save(enseignant);
      return 1;
		
	}
}
@Override
public int updateEnseignant(Enseignant enseignant) {  
    	Enseignant enseignantFounded = enseignantDao.findById(enseignant.getId()).get();
		if(enseignantFounded == null){
			return -1;
		}else {
			enseignantFounded.setCin(enseignant.getCin());
			enseignantFounded.setDepartement(enseignant.getDepartement());
			enseignantFounded.setLogin(enseignant.getLogin());
			enseignantFounded.setNom(enseignant.getNom());
			enseignantFounded.setPrenom(enseignant.getPrenom());
			String salt = enseignant.getSalt();
			 String Password = PasswordUtils.generateSecurePassword(enseignant.getMotDePasse(), salt);
			 enseignantFounded.setMotDePasse(Password);
			enseignantDao.save(enseignantFounded);
			return 1;
		}
}


@Override
@Transactional
public int deleteByCin(String cin) {
	Enseignant enseignant=findByCin(cin);
	if(enseignant==null) {
		return -1;
	}else {
		enseignantDao.deleteByCin(cin);
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
		enseignantFounded.setNombreEssais(0);
		enseignantFounded.setStatut(statut);
		enseignantDao.save(enseignantFounded);
		return 1;
		}else {
			enseignantFounded.setNombreEssais(3);
			enseignantFounded.setStatut(statut);
			enseignantDao.save(enseignantFounded);
			return 2;
		}
	}
}

@Override
public int deleteByLogin(String login) {
	// TODO Auto-generated method stub
	return 0;
}


}
