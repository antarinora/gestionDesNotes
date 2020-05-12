package com.examplegestionDesNotes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.ModuleSemestre;
import com.examplegestionDesNotes.dao.ModuleSemestreDao;
import com.examplegestionDesNotes.service.ModuleSemestreService;

@Service
public class ModuleSemestreImpl implements ModuleSemestreService {
@Autowired
public ModuleSemestreDao moduleSemestreDao;

@Override
public List<ModuleSemestre> findAll() {
	
	return moduleSemestreDao.findAll();
}

@Override
public void save(ModuleSemestre moduleSemestre) {
	moduleSemestreDao.save(moduleSemestre);
	
}

}
