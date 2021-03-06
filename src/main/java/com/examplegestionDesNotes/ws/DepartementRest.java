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

import com.examplegestionDesNotes.bean.Departement;
import com.examplegestionDesNotes.service.facade.DeparetementService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/departement")
public class DepartementRest {
@Autowired
public DeparetementService deparetementService;

@PostMapping("/")
public int save(@RequestBody Departement departement) {
	return deparetementService.save(departement);
	}


@GetMapping("/nom/{nom}")
public Departement findByNom(@PathVariable String nom) {
	return deparetementService.findByNom(nom);
}

@GetMapping("/")
public List<Departement> findAll() {
	return deparetementService.findAll();
}

@PutMapping("/updateDepartement")
public int updateDepartement( @RequestBody Departement departement) {
	return deparetementService.updateDepatement(departement);
}
@DeleteMapping("/code/{code}")
public int deleteByCode( @PathVariable String code) {
	return deparetementService.deleteByCode(code);
}
@GetMapping("/departement")
public int departementTotale() {
	return deparetementService.departementTotale();
}

}
