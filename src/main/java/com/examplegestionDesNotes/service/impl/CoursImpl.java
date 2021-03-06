package com.examplegestionDesNotes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Cours;
import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.dao.CoursDao;
import com.examplegestionDesNotes.service.facade.CoursService;
import com.examplegestionDesNotes.service.facade.EnsiegnantService;
import com.examplegestionDesNotes.service.facade.ModuleService;

@Service
public class CoursImpl implements CoursService{
@Autowired
public CoursDao coursDao;
@Autowired
public EnsiegnantService ensiegnantService;
@Autowired
public ModuleService moduleService;

@Override
public List<Cours> findAll() {
	return coursDao.findAll();
}

@Override
public int save(Cours cours) {
	Enseignant enseignant=ensiegnantService.findByNom(cours.getEnseignant().getNom());
	Module module=moduleService.findByNom(cours.getModule().getNom());
	if(enseignant==null) {
		ensiegnantService.save(cours.getEnseignant());
		cours.setEnseignant(cours.getEnseignant());
		cours.setModule(module);
		cours.setAnnee(cours.getAnnee());
		coursDao.save(cours);
		return 2;
	}else if(module==null) {
		return -2;
	}else {
		cours.setEnseignant(enseignant);
		cours.setModule(module);
		cours.setAnnee(cours.getAnnee());
		coursDao.save(cours);
		return 1;
	}
}
	public int updateCours(Cours cours) {  
    	Cours coursFounded = coursDao.findById(cours.getId()).get();
		if(coursFounded == null){
			return -1;
		}else {
			moduleService.updateModule(cours.getModule());
			coursFounded.getModule().setNom(cours.getModule().getNom());
			coursFounded.getModule().setAbreviation(cours.getModule().getAbreviation());
			coursFounded.getModule().setCode(cours.getModule().getCode());
			moduleService.updateModule(cours.getModule()); 
			coursFounded.setEnseignant(cours.getEnseignant());
			coursFounded.getModule().setNom(cours.getModule().getNom());
			coursFounded.getModule().setAbreviation(cours.getModule().getAbreviation());
			coursFounded.getModule().setCode(cours.getModule().getCode());
			coursDao.save(coursFounded);
			return 1;
		}
	



}

@Override
@Transactional
public int deleteByModuleNom(String nom) {
	Module module=moduleService.findByNom(nom);
	if(module==null) {
		return -1;
	}else {
		coursDao.deleteByModule(module.getId());
		return 1;
}
}






}




