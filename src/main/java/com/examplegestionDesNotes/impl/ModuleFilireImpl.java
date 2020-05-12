package com.examplegestionDesNotes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.ModuleFiliere;
import com.examplegestionDesNotes.dao.ModuleFiliereDao;
import com.examplegestionDesNotes.service.ModuleFiliereService;

@Service
public class ModuleFilireImpl implements ModuleFiliereService {
	@Autowired
	public ModuleFiliereDao moduleFiliereDao;

	@Override
	public List<ModuleFiliere> findAll() {
		
		return moduleFiliereDao.findAll();
	}

	@Override
	public void save(ModuleFiliere moduleFiliere) {
		moduleFiliereDao.save(moduleFiliere);
		
	}

}
