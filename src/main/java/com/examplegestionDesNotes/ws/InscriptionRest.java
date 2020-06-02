package com.examplegestionDesNotes.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.service.facade.InscriptionService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/inscription")
public class InscriptionRest {
	
	@Autowired
    private InscriptionService inscriptionService;
	@PostMapping("/")
	public int save(@RequestBody Inscription inscription) {
		return inscriptionService.save(inscription);
	}
	
	
	
}
