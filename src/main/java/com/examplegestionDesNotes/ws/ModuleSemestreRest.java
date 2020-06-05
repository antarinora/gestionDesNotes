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

import com.examplegestionDesNotes.bean.ModuleSemestre;
import com.examplegestionDesNotes.service.facade.ModuleSemestreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/moduleSemestre")
public class ModuleSemestreRest {
@Autowired
public ModuleSemestreService moduleSemestreService;

@GetMapping("/")
public List<ModuleSemestre> findAll() {
	
	return moduleSemestreService.findAll();
}

@PostMapping("/")
public int save(@RequestBody ModuleSemestre moduleSemestre) {
	return moduleSemestreService.save(moduleSemestre);
	
}
@PutMapping("/")
public int updateModuleSemestre(@RequestBody ModuleSemestre moduleSemestre) {
	return moduleSemestreService.updateModuleSemestre(moduleSemestre);
}
@DeleteMapping("/nom/{nom}")
public int deleteByModuleNom(@PathVariable String nom) {
	return moduleSemestreService.deleteByModuleNom(nom);
}
}
