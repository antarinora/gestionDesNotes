package com.examplegestionDesNotes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.ModuleFiliere;
import com.examplegestionDesNotes.service.ModuleFiliereService;

@RestController
@RequestMapping("gestionDesNotes/moduleFiliere")
public class ModuleFiliereRest {
	@Autowired
	public ModuleFiliereService moduleFiliereService;
	@GetMapping("/")
	public List<ModuleFiliere> findAll() {
		
		return moduleFiliereService.findAll();
	}

	@PostMapping("/")
	public void save(@RequestBody ModuleFiliere moduleFiliere) {
		moduleFiliereService.save(moduleFiliere);
		
	}


}
