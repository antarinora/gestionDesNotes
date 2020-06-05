package com.examplegestionDesNotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int updateModuleFiliere(ModuleFiliere moduleFiliere) {
		ModuleFiliere moduleFiliereFounded=moduleFiliereDao.findById(moduleFiliere.getId()).get();
		if(moduleFiliereFounded==null) {
			return -1;
		}else {
			moduleService.updateModule(moduleFiliere.getModule());
			moduleFiliereFounded.getModule().setNom(moduleFiliere.getModule().getNom());
			moduleFiliereFounded.getModule().setAbreviation(moduleFiliere.getModule().getAbreviation());
			moduleFiliereFounded.getModule().setCode(moduleFiliere.getModule().getCode());
			moduleService.updateModule(moduleFiliere.getModule()); 
			moduleFiliereFounded.setFiliere(moduleFiliere.getFiliere());
			moduleFiliereFounded.getModule().setNom(moduleFiliere.getModule().getNom());
			moduleFiliereFounded.getModule().setAbreviation(moduleFiliere.getModule().getAbreviation());
			moduleFiliereFounded.getModule().setCode(moduleFiliere.getModule().getCode());
			moduleFiliereDao.save(moduleFiliereFounded);
			return 1;
		}
	}

}
