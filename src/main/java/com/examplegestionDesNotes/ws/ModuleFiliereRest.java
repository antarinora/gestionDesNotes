package com.examplegestionDesNotes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.ModuleFiliere;
import com.examplegestionDesNotes.service.facade.ModuleFiliereService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/moduleFiliere")
public class ModuleFiliereRest {
	@Autowired
	public ModuleFiliereService moduleFiliereService;
	@GetMapping("/")
	public List<ModuleFiliere> findAll() {
		
		return moduleFiliereService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody ModuleFiliere moduleFiliere) {
		return moduleFiliereService.save(moduleFiliere);
		
	}
@PutMapping("/")
public int updateModuleFiliere(@PathVariable ModuleFiliere moduleFiliere) {
return moduleFiliereService.updateModuleFiliere(moduleFiliere);
}

}
