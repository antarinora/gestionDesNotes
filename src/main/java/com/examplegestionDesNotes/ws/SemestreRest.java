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

	@GetMapping("/nom/{code}/cne/{cne}")
	public List<Semestre> finByFiliereCodeAndEtudiantCne(@PathVariable String code,@PathVariable String cne) {
		return semestreService.finByFiliereCodeAndEtudiantCne(code, cne);
		}
	@GetMapping("/nom1/{nom}")
	public List<Semestre> findByModuleNom(@PathVariable String nom) {
		return semestreService.findByModuleNom(nom);
	}
	@GetMapping("/nom2/{nom}")
	public List<Semestre> findByFiliereNom(@PathVariable String nom){
		return semestreService.findByFiliereNom(nom);
	}
	
	@PutMapping("/updateSemestre")
	public int updateSemestre( @RequestBody Semestre semestre) {
		return semestreService.updateSemestre(semestre);
	}
	@DeleteMapping("/nom/{nom}")
	public int deleteByNom( @PathVariable String nom) {
		return semestreService.deleteByNom(nom);
	}
    @PutMapping("/statut/{statut}")	
	public int updatStatut(@RequestBody Semestre semestre,@PathVariable boolean statut) {
    	return semestreService.updatStatut(semestre, statut);
    }
    @GetMapping("/semestre")
	public int semestreTotale() {
    return semestreService.semestreTotale();
    }
}
