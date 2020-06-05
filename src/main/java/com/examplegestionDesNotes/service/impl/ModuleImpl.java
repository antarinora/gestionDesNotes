package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Cours;
import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.ModuleFiliere;
import com.examplegestionDesNotes.bean.ModuleSemestre;
import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.bean.Semestre;
import com.examplegestionDesNotes.dao.ModuleDao;
import com.examplegestionDesNotes.service.facade.CoursService;
import com.examplegestionDesNotes.service.facade.EnsiegnantService;
import com.examplegestionDesNotes.service.facade.EtudiantService;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.ModuleFiliereService;
import com.examplegestionDesNotes.service.facade.ModuleSemestreService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.NoteService;
import com.examplegestionDesNotes.service.facade.SemestreService;

@Service
public class ModuleImpl implements ModuleService {
	@Autowired
	public ModuleDao moduleDao;
	@Autowired
	public ModuleFiliereService moduleFiliereService;
	@Autowired
	public FiliereService filiereService;
	@Autowired
	public NoteService noteService;
	@Autowired
	public EtudiantService etudiantService;
	@Autowired
	public SemestreService semestreService;
	@Autowired
	public ModuleSemestreService moduleSemestreService;
	@Autowired 
	public CoursService coursService;
	@Autowired
	public EnsiegnantService ensiegnantService;
	@Autowired
	public ModuleService moduleService;

	@Override
	public int save(Module module) {
		if(findByNom(module.getNom())!=null) {
			return -1;
		}else {
			moduleDao.save(module);
			return 1;
		}
		
	}

	@Override
	public Module findByNom(String nom) {
		
		return moduleDao.findByNom(nom);
	}

	@Override
	public List<Module> findAll() {
		return moduleDao.findAll();
	}

	@Override
	public List<Module> findByFiliereNom(String nom) {
		List<ModuleFiliere>moduleFilieres=moduleFiliereService.findAll();
		List<Module>modules=new ArrayList<Module>();
		for(ModuleFiliere moduleFiliere:moduleFilieres) {
			if(moduleFiliere.getFiliere().equals(filiereService.findByNom(nom)))
				modules.add(moduleFiliere.getModule());
		}
		return modules;
	}

	@Override
	public List<Module> findByEtudiantCne(String cne) {
		List<Note>notes=noteService.findAll();
		List<Module>modules=new ArrayList<Module>();
		for(Note note:notes) {
			if(note.getEtudiant().equals(etudiantService.findByCne(cne)))
				modules.add(note.getModule());
		}
		return modules;
	}

	@Override
	public List<Module> findBySemestreNom(String nom) {
		Semestre semestre=semestreService.findByNom(nom);
		List<Module>modules=new ArrayList<Module>();
		List<ModuleSemestre>moduleSemestres=moduleSemestreService.findAll();
		for(ModuleSemestre m:moduleSemestres) {
			if(m.getSemestre().equals(semestre))
				modules.add(m.getModule());
				
		}
		return modules;
	}

	@Override
	public List<Module> findByEtudiantCneAndSemestreNom(String cne, String nom) {
		List<Module>modules=findByEtudiantCne(cne);
		List<Module>modules2=findBySemestreNom(nom);
		List<Module>modules3=new ArrayList<Module>();
		for(Module module:modules2) {
			for(Module m:modules) {
				if(module.equals(m))
				modules3.add(module);	
			}
		}
		return modules3;
	}

	@Override
	public List<Module> findByEnseignantLogin(String login) {
		Enseignant enseignant=ensiegnantService.findByLogin(login);
		List<Cours>cours=coursService.findAll();
		List<Module>modules=new ArrayList<Module>();
		for(Cours c:cours) {
			if(c.getEnseignant().equals(enseignant)) {
				modules.add(c.getModule());
			}
		}
		return modules;
	}


	
	public int updateModule(Module module) {  
    	Module moduleFounded = moduleDao.findById(module.getId()).get();
		if(moduleFounded == null){
			return -1;
		}else {
			moduleFounded.setAbreviation(module.getAbreviation());
			moduleFounded.setCode(module.getCode());
			moduleFounded.setNom(module.getNom());
			moduleDao.save(moduleFounded);
			return 1;
		}
}
		
	
	@Override
	@Transactional
	public int deleteByModuleNom(String nom) {
		Module module=moduleService.findByNom(nom);
		if(module==null) {
			return -1;
		}else {
			moduleDao.deleteByModule(module.getId());
			return 1;
	}
	}
	
	

}
