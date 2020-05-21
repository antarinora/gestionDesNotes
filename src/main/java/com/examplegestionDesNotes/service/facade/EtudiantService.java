package com.examplegestionDesNotes.service.facade;

import java.util.Date;
import java.util.List;

import com.examplegestionDesNotes.bean.Etudiant;

public interface EtudiantService {
	public int save(Etudiant etudiant);
	public List<Etudiant> findAll();
	public Etudiant findByCne(String cne);
	public int findByCneAndCodeApogeeAndDateNaissance(String cne,Long codeApogee,Date dateNaissance);
}
