package com.examplegestionDesNotes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Departement;
import com.examplegestionDesNotes.dao.DepartemantDao;
import com.examplegestionDesNotes.service.facade.DeparetementService;

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
@Transactional
@Override
public int deleteByCode(String code) {
	if (findByCode(code) == null)
		return -1;
	else {
		departemantDao.deleteByCode(code);
		return 1;
	}
}

@Override
public Departement findByNom(String nom) {
	return departemantDao.findByNom(nom);
}

public Departement findByCode(String code) {
	return departemantDao.findByCode(code);
}
@Override
public List<Departement> findAll() {
	return departemantDao.findAll();
}
public int updateDepatement(Departement departement) {  
	Departement departementFounded = departemantDao.findById(departement.getId()).get();
	if(departementFounded == null){
		return -1;
	}else {
		departementFounded.setCode(departement.getCode());
		departementFounded.setNom(departement.getNom());
		departementFounded.setResponsable(departement.getResponsable());
		departemantDao.save(departementFounded);
		return 1;
	}
}


}
