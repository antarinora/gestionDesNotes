package com.examplegestionDesNotes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.service.facade.ModuleService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/module")
public class ModuleRest {
@Autowired
public ModuleService moduleService;

@PostMapping("/")
public int save(@RequestBody Module module) {
	return moduleService.save(module);
}

@GetMapping("/nom/{nom}")
public Module findByNom(@PathVariable String nom) {
	
	return moduleService.findByNom(nom);
}

@GetMapping("/")
public List<Module> findAll() {
	return moduleService.findAll();
}

@GetMapping("/nom1/{nom}")
public List<Module> findByFiliereNom(@PathVariable String nom) {
	return moduleService.findByFiliereCode(nom);
}
@GetMapping("/cne/{cne}")

public List<Module> findByEtudiantCne(@PathVariable String cne) {
	return moduleService.findByEtudiantCne(cne);
}
@GetMapping("/nom2/{nom}")
public List<Module> findBySemestreNom(@PathVariable String nom){
	return moduleService.findBySemestreNom(nom);
}
@GetMapping("/cne/{cne}/nom/{nom}")
public List<Module> findByEtudiantCneAndSemestreNom(@PathVariable String cne,@PathVariable String nom){
	return moduleService.findByEtudiantCneAndSemestreNom(cne, nom);
}
@GetMapping("/login/{login}")
public List<Module> findByEnseignantLogin(@PathVariable String login) {
	return moduleService.findByEnseignantLogin(login);
}
@PutMapping("/")
public int updateModule( @PathVariable Module module) {
	return moduleService.updateModule(module);
}
@DeleteMapping("/nom/{nom}")
public int deleteByModuleNom(@PathVariable String nom) {
	return moduleService.deleteByModuleNom(nom);
}
@GetMapping("/module")
public int moduleTotale() {
	return moduleService.moduleTotale();


}
}
