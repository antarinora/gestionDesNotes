package com.examplegestionDesNotes.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.dao.EtudiantDao;
import com.examplegestionDesNotes.service.EtudiantService;

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
		List<Etudiant> etudiants=findAll();
		for(Etudiant e:etudiants) {
			if(e.getCne().equals(cne) && e.getCodeApogee().equals(codeApogee) && e.getDateNaissance().equals(dateNaissance)) {
				return 1;
				}
		}
		return -1;
	}
	

}
