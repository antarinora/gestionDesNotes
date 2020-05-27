package com.examplegestionDesNotes.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.dao.EtudiantDao;
import com.examplegestionDesNotes.service.facade.EtudiantService;
@Service
public class EtudiantImpl implements EtudiantService {

@Autowired
public EtudiantDao etudiantDao;
	@Override
	public int save(Etudiant etudiant)  {
		Etudiant etudiantFounded =findByCne(etudiant.getCne());
		if(etudiantFounded==null) {
			etudiantDao.save(etudiant);
			return 1;
		}
		else return -1;
		
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
	public ResponseEntity<List<Etudiant>> importExcelFile( MultipartFile files) throws IOException {
		{
		 HttpStatus status = HttpStatus.OK;
		                List<Etudiant> etudiantListe = new ArrayList<>();
		       XSSFWorkbook  workbook = new XSSFWorkbook(files.getInputStream());
		        XSSFSheet worksheet = workbook.getSheetAt(0);
		 
				
		        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
		            if (index > 0) {
		       
		            	Etudiant etudiant = new Etudiant();
		                XSSFRow row = worksheet.getRow(index);
		                DataFormatter formatter = new DataFormatter();
		                etudiant.setCodeApogee((long) row.getCell(1).getNumericCellValue());
		                etudiant.setNom(row.getCell(4).getStringCellValue());
		                etudiant.setPrenom(row.getCell(5).getStringCellValue());
		                etudiant.setCne(formatter.formatCellValue(row.getCell(2)));
		                etudiant.setCin(formatter.formatCellValue(row.getCell(3)));
		                   etudiantListe.add(etudiant);
		            }
		           
		        }

		        return new ResponseEntity<>(etudiantListe, status);
		    }
	}

	
	



}
