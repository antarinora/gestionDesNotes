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

import com.examplegestionDesNotes.bean.Semestre;
import com.examplegestionDesNotes.service.facade.SemestreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/semestre")
public class SemestreRest {
	@Autowired
public SemestreService semestreService;
	
	@PostMapping("/")
	public int save(@RequestBody Semestre semestre) {
		return semestreService.save(semestre);
	}

	@GetMapping("/nom/{nom}")
	public Semestre findByNom(@PathVariable String nom) {
		return semestreService.findByNom(nom);
	}

	@GetMapping("/")
	public List<Semestre> findAll() {
		
		return semestreService.findAll();
	}

	@GetMapping("/nom/{nom}/cne/{cne}")
	public List<Semestre> finByFiliereNomAndEtudiantCne(@PathVariable String nom,@PathVariable String cne) {
		return semestreService.finByFiliereNomAndEtudiantCne(nom, cne);
		}
	@GetMapping("/nom1/{nom}")
	public List<Semestre> findByModuleNom(@PathVariable String nom) {
		return semestreService.findByModuleNom(nom);
	}
	@GetMapping("/nom2/{nom}")
	public List<Semestre> findByFiliereNom(@PathVariable String nom){
		return semestreService.findByFiliereNom(nom);
	}
}
