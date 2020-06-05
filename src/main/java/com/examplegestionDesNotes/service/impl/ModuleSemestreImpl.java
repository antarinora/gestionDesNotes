package com.examplegestionDesNotes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.ModuleSemestre;
import com.examplegestionDesNotes.bean.Semestre;
import com.examplegestionDesNotes.dao.ModuleSemestreDao;
import com.examplegestionDesNotes.service.facade.CoursService;
import com.examplegestionDesNotes.service.facade.ModuleFiliereService;
import com.examplegestionDesNotes.service.facade.ModuleSemestreService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.SemestreService;

@Service
public class ModuleSemestreImpl implements ModuleSemestreService {
@Autowired
public ModuleSemestreDao moduleSemestreDao;
@Autowired
public ModuleService moduleService;
@Autowired
public SemestreService semestreService;
@Autowired
public ModuleFiliereService moduleFiliereService;
@Autowired
public CoursService coursService;
@Override
public List<ModuleSemestre> findAll() {
	
	return moduleSemestreDao.findAll();
}

@Override
public int save(ModuleSemestre moduleSemestre) {
	Module module = moduleService.findByNom(moduleSemestre.getModule().getNom());
	Semestre semestre =semestreService.findByNom(moduleSemestre.getSemestre().getNom());
	if(module==null) {
		moduleService.save(moduleSemestre.getModule());
		moduleSemestre.setModule(moduleSemestre.getModule());
		moduleSemestre.setSemestre(semestre);
		moduleSemestreDao.save(moduleSemestre);
		return 2;
	}else if(semestre==null) {
		return -1;
	}else {
		moduleSemestre.setModule(module);
		moduleSemestre.setSemestre(semestre);
		moduleSemestreDao.save(moduleSemestre);
		return 1;
	}
	
	
}

@Override
public int updateModuleSemestre(ModuleSemestre moduleSemestre) {
	ModuleSemestre moduleSemestrefounded=moduleSemestreDao.findById(moduleSemestre.getId()).get();
	if(moduleSemestrefounded==null) {
		return -1;
	}else {
		moduleSemestrefounded.setModule(moduleSemestre.getModule());
		moduleSemestrefounded.setSemestre(moduleSemestre.getSemestre());
		moduleSemestreDao.save(moduleSemestrefounded); 
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
		moduleSemestreDao.deleteByModule(module.getId());
		moduleFiliereService.deleteByModuleNom(nom);
		coursService.deleteByModuleNom(nom);
		moduleService.deleteByModuleNom(nom);
		return 1;
}
}


}
