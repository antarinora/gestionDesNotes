package com.examplegestionDesNotes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.service.EnsiegnantService;

@RestController
@RequestMapping("gestionDesNotes/enseignant")
public class EnseignantRest {
@Autowired
public EnsiegnantService ensiegnantService;

@PostMapping("/")
public int save(@RequestBody Enseignant enseignant) {
	return ensiegnantService.save(enseignant);
}

@GetMapping("/nom/{nom}")
public Enseignant findByNom(@PathVariable String nom) {
	return ensiegnantService.findByNom(nom);
}

@GetMapping("/")
public List<Enseignant> findAll() {
	
	return ensiegnantService.findAll();
}


}
