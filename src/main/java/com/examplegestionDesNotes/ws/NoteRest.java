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

import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.service.facade.NoteService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/note")
public class NoteRest {
	@Autowired
	public NoteService noteService;
	
	@PostMapping("/")
	public void save(@RequestBody Note note) {
		noteService.save(note);
		
	}

	@GetMapping("/")
	public List<Note> findAll() {
		
		return noteService.findAll();
	}
	
	@GetMapping("/cne/{cne}/nom/{nom}")
	public Note findByEtidaintCneAndModuleNom(@PathVariable String cne,@PathVariable String nom) {
	return noteService.findByEtidaintCneAndModuleNom(cne, nom);
	}
}
