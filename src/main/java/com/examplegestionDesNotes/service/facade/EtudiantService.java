package com.examplegestionDesNotes.service.facade;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.examplegestionDesNotes.bean.Etudiant;

public interface EtudiantService {
	public int save(Etudiant etudiant)  ;
	public ResponseEntity<List<Etudiant>> importExcelFile( MultipartFile files)throws IOException;
	public List<Etudiant> findAll();
	public Etudiant findByCne(String cne);
	public int findByCneAndCodeApogeeAndDateNaissance(String cne,Long codeApogee,Date dateNaissance);
}
