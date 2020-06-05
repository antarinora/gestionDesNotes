package com.examplegestionDesNotes.ws;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.service.facade.EtudiantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/etudiant")
public class EtudiantRest {
@Autowired
public EtudiantService etudiantService;
@PostMapping("/")
public int save(@RequestBody Etudiant etudiant) {
	return etudiantService.save(etudiant);
	}


@GetMapping("/")
public List<Etudiant> findAll() {
	return etudiantService.findAll();
}

@GetMapping("/cne/{cne}")
public Etudiant findByCne(@PathVariable String cne) {
	return etudiantService.findByCne(cne);
}

@GetMapping("/cne/{cne}/codeApogee/{codeApogee}/dateNaissance/{dateNaissance}")
public int findByCneAndCodeApogeeAndDateNaissance(@PathVariable String cne, @PathVariable Long codeApogee,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateNaissance) {
	return etudiantService.findByCneAndCodeApogeeAndDateNaissance(cne, codeApogee, dateNaissance);
}

@PutMapping("/")
public int updateEtudian(@RequestBody Etudiant etudiant) {
	return etudiantService.updateEtudian(etudiant);
}
@DeleteMapping("/cne/{cne}")
public int deleteByCne(@PathVariable String cne) {
	return etudiantService.deleteByCne(cne);
}






}
