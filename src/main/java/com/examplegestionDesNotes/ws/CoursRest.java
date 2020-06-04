package com.examplegestionDesNotes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Cours;
import com.examplegestionDesNotes.service.facade.CoursService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/cours")
public class CoursRest {
	@Autowired
	public CoursService coursService;
	@GetMapping("/")
	public List<Cours> findAll() {
		return coursService.findAll();
	}

@PostMapping("/")
	public int save(@RequestBody Cours cours) {
		return coursService.save(cours);
	}

@PutMapping("/updateCours")
public int updateModule( @RequestBody Cours cours) {
	return coursService.updateCours(cours);
}
}
