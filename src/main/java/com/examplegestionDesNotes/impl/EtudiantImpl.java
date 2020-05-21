package com.examplegestionDesNotes.impl;

import java.io.ByteArrayInputStream;
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
import com.examplegestionDesNotes.service.EtudiantService;
import com.examplegestionDesNotes.util.ImportUtil;

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
	
	 public ResponseEntity<List<Etudiant>> importExcelFile( MultipartFile files) throws IOException {
		{
		 HttpStatus status = HttpStatus.OK;
		                List<Etudiant> etudiantListe = new ArrayList<>();
		        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
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
		               etudiant.setDateNaissance(row.getCell(10).getDateCellValue());
		                   etudiantListe.add(etudiant);
		            }
		           
		        }

		        return new ResponseEntity<>(etudiantListe, status);
		    }
	}
	 public void save(MultipartFile file) {
		    try {
		      List<Etudiant> tutorials = ImportUtil.excelToTutorials(file.getInputStream());
		      etudiantDao.saveAll(tutorials);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }

		  public ByteArrayInputStream load() {
		    List<Etudiant> tutorials = etudiantDao.findAll();

		    ByteArrayInputStream in = ImportUtil.tutorialsToExcel(tutorials);
		    return in;
		  }

		  public List<Etudiant> getAllTutorials() {
		    return etudiantDao.findAll();
		  }
	

}
