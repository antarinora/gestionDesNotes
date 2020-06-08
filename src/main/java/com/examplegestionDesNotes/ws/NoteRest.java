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

import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.service.facade.NoteService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/note")
public class NoteRest {
	@Autowired
	public NoteService noteService;
	
	@PostMapping("/")
	public int save(@RequestBody Note note) {
		return noteService.save(note);
		
	}

	@GetMapping("/")
	public List<Note> findAll() {
		
		return noteService.findAll();
	}
	
	@GetMapping("/cne/{cne}/nom/{nom}")
	public Note findByEtidaintCneAndModuleNom(@PathVariable String cne,@PathVariable String nom) {
	return noteService.findByEtidaintCneAndModuleNom(cne, nom);
	}
	@GetMapping("/nom/{nom}/codeApogee/{codeApogee}")
	public Note findByModuleNomAndEtudiantCodeApogee(@PathVariable String nom,@PathVariable Long codeApogee) {
		return noteService.findByModuleNomAndEtudiantCodeApogee(nom, codeApogee);
	}
	@PutMapping("/up")
	public int updateNote(@RequestBody Note note) {
		return noteService.updateNote(note);
	}
   @GetMapping("/nom/{nom}")
   public List<Note> findByModuleNomNonNull(@PathVariable String nom) {
	   return noteService.findByModuleNomNonNull(nom);
   }
   @PostMapping("/filierenom/{nom}")
	public int saveDeux(@PathVariable String nom,@RequestBody Note note) {
		return noteService.saveDeux( note,nom);
	}
   @PutMapping("/")
   public int updateTableNote(@RequestBody Note note) {
	   return noteService.updateTableNote(note);
   }
   @PutMapping("/del")
   public int update(@RequestBody Note note) {
	   return noteService.update(note);
   }
   @DeleteMapping("/cne/{cne}")
   public int deleteByCne(@PathVariable String cne) {
   	return noteService.deleteByEtudiantCne(cne);
   }
}
