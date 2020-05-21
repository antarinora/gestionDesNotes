package com.examplegestionDesNotes.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Etudiant;
import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.service.facade.FiliereService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/filiere")
public class FiliereRest {
@Autowired
public FiliereService filiereService;
@PostMapping("/")
public int save(@RequestBody Filiere filiere) {
	return filiereService.save(filiere);
}

@GetMapping("/")
public List<Filiere> findAll() {
	return filiereService.findAll();
}

@GetMapping("/nom/{nom}")
public Filiere findByNom(@PathVariable String nom) {
	return filiereService.findByNom(nom);
}

@GetMapping("/cne/{cne}")
public List<Filiere> findByEtudiantCne(@PathVariable String cne) {
	return filiereService.findByEtudiantCne(cne);
}

}
