package com.examplegestionDesNotes.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.dao.EtudiantDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;

@Service
public class EtudiantImpl implements EtudiantService {
@Autowired
public EtudiantDao etudiantDao;
	@Override
	public int save(Etudiant etudiant) {
		if(findByCne(etudiant.getCne())!=null)
			return -1;
		else {
			etudiantDao.save(etudiant);
			return 1;
		}
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDao.findAll();
	}

	@Override
	public Etudiant findByCne(String cne) {
		return etudiantDao.findByCne(cne);
	}

	@Override
	public int findByCneAndCodeApogeeAndDateNaissance(String cne, Long codeApogee, Date dateNaissance) {
		Etudiant etudiant=findByCne(cne);
		if(etudiant==null) {
			return -1;
		}else if(!etudiant.getCodeApogee().equals(codeApogee)) {
				return -2;
			}else if(!etudiant.getDateNaissance().equals(dateNaissance)) {
				return -3;
	}else {
		return 1;
	}
	
	}
	

}
