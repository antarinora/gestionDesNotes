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


@GetMapping("/")
public List<Enseignant> findAll() {
	
	return ensiegnantService.findAll();
}
@GetMapping("/login/{login}")
public Enseignant findByLogin(@PathVariable String login) {
	return ensiegnantService.findByLogin(login);
}
@GetMapping("/nom/{nom}")
public Enseignant findByNom(String nom) {
	return ensiegnantService.findByNom(nom);
}
@GetMapping("/login/{login}/motDePasse/{motDePasse}")
public int findByLoginAndMotDePasse(@PathVariable String login,@PathVariable String motDePasse) {
	return ensiegnantService.findByLoginAndMotDePasse(login, motDePasse);
}
@GetMapping("/login1/{login1}/motDePasse/{motDePasse}/login2/{login2}")
public int updateLogin(@PathVariable String login1,@PathVariable String motDePasse,@PathVariable String login2) {
	return ensiegnantService.updateLogin(login1, motDePasse, login2);
}
@GetMapping("/login/{login}/motDePasse/{motDePasse}/motDePasse2/{motDePasse2}")
public int updateMotDePass(@PathVariable String login,@PathVariable String motDePasse,@PathVariable String motDePasse2) {
	return ensiegnantService.updateMotDePass(login, motDePasse, motDePasse2);
}
}
