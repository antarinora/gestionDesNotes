package com.examplegestionDesNotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.ModuleFiliere;
import com.examplegestionDesNotes.dao.ModuleFiliereDao;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.ModuleFiliereService;
import com.examplegestionDesNotes.service.facade.ModuleService;

@Service
public class ModuleFilireImpl implements ModuleFiliereService {
	@Autowired
	public ModuleFiliereDao moduleFiliereDao;
	@Autowired
	public ModuleService moduleService;
	@Autowired
	public FiliereService filiereService;

	@Override
	public List<ModuleFiliere> findAll() {
		
		return moduleFiliereDao.findAll();
	}

	@Override
	public int save(ModuleFiliere moduleFiliere) {
		Module module=moduleService.findByNom(moduleFiliere.getModule().getNom());
		Filiere filier=filiereService.findByNom(moduleFiliere.getFiliere().getNom());

		if(module==null) {
			moduleService.save(moduleFiliere.getModule());
			moduleFiliere.setModule(moduleFiliere.getModule());
			moduleFiliere.setFiliere(filier);
			moduleFiliereDao.save(moduleFiliere);
			return 2;
		}else if(filier==null) {
			return -2;
		}else {
		moduleFiliere.setModule(module);
		moduleFiliere.setFiliere(filier);
		moduleFiliereDao.save(moduleFiliere);
		return 1;
		}
	}

}
