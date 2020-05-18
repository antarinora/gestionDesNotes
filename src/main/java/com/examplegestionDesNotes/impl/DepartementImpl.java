package com.examplegestionDesNotes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Departement;
import com.examplegestionDesNotes.dao.DepartemantDao;
import com.examplegestionDesNotes.service.DeparetementService;

@Service
public class DepartementImpl implements DeparetementService {
@Autowired
public DepartemantDao departemantDao;

@Override
public int save(Departement departement) {
	if(findByNom(departement.getNom())!=null)
		return -1;
	else {
		departemantDao.save(departement);
		return 1;
	}
}

@Override
public Departement findByNom(String nom) {
	return departemantDao.findByNom(nom);
}

@Override
public List<Departement> findAll() {
	return departemantDao.findAll();
}

}
