package com.examplegestionDesNotes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.service.facade.EnsiegnantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
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
@GetMapping("/login/{login}")
public Enseignant findByLogin(@PathVariable String login) {
	return ensiegnantService.findByLogin(login);
}
@GetMapping("/login/{login}/motDePasse/{motDePasse}")
public int findByLoginAndMotDePasse(@PathVariable String login,@PathVariable String motDePasse) {
	return ensiegnantService.findByLoginAndMotDePasse(login, motDePasse);
}

}
