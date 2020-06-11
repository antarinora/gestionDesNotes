package com.examplegestionDesNotes.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Filiere;
import com.examplegestionDesNotes.bean.Module;
import com.examplegestionDesNotes.bean.ModuleFiliere;
import com.examplegestionDesNotes.bean.ModuleSemestre;
import com.examplegestionDesNotes.bean.Note;
import com.examplegestionDesNotes.bean.Semestre;
import com.examplegestionDesNotes.dao.SemestreDao;
import com.examplegestionDesNotes.service.facade.FiliereService;
import com.examplegestionDesNotes.service.facade.ModuleFiliereService;
import com.examplegestionDesNotes.service.facade.ModuleSemestreService;
import com.examplegestionDesNotes.service.facade.ModuleService;
import com.examplegestionDesNotes.service.facade.NoteService;
import com.examplegestionDesNotes.service.facade.SemestreService;

@Service
public class SemestreImpl implements SemestreService {
	@Autowired
	public SemestreDao semestreDao;
	@Autowired
 public ModuleFiliereService moduleFiliereService;
	@Autowired
	public NoteService noteService;
	@Autowired
	public ModuleSemestreService moduleSemestreService;
	@Autowired
	public FiliereService FiliereService;
	@Autowired
	public ModuleService moduleService;

	@Override
	public int save(Semestre semestre) {
		if(findByNom(semestre.getNom())!=null)
			return -1;
		else {
			semestreDao.save(semestre);
			return 1;
		}
	}

	@Override
	public Semestre findByNom(String nom) {
		return semestreDao.findByNom(nom);
	}

	@Override
	public List<Semestre> findAll() {
		
		return semestreDao.findAll();
	}

	@Override
	public List<Semestre> findByModuleNom(String nom) {
		List<ModuleSemestre>moduleSemestres=moduleSemestreService.findAll();
		List<Semestre>semestres=new ArrayList<Semestre>();
		for(ModuleSemestre moduleSemestre:moduleSemestres) {
			if(moduleSemestre.getModule().equals(moduleService.findByNom(nom)))
				semestres.add(moduleSemestre.getSemestre());
		}
		 return semestres;
	}

	@Override
	public List<Semestre> finByFiliereNomAndEtudiantCne(String nom, String cne) {
		List<Module>modules=moduleService.findByFiliereNom(nom);
		List<Module>modules2=moduleService.findByEtudiantCne(cne);
		List<Semestre>semestres=new ArrayList<Semestre>();
		for(Module module:modules) {
			for(Module module2:modules2) {
				if(module.equals(module2))
					semestres.addAll(findByModuleNom(module2.getNom()));
			}
		}
	   Set<Semestre> se = new HashSet<Semestre>(semestres);
	   List<Semestre>semestres2=new ArrayList<Semestre>(se);
		return semestres2;
	}

	@Override
	public List<Semestre> findByFiliereNom(String nom) {
		List<Module>modules=moduleService.findByFiliereNom(nom);
		List<Semestre>semestres=new ArrayList<Semestre>();
		for(Module module:modules) {
			List<Semestre>semestres1=findByModuleNom(module.getNom());
			semestres.addAll(semestres1);
		}
		
		
		return semestres;
	}

	@Override
	public int updatStatut(Semestre semestre, boolean statut) {
		Semestre semestreFounded=findByNom(semestre.getNom());
		if(semestreFounded==null) {
			return -1;
		}else {
			semestreFounded.setStatut(statut);
			semestreDao.save(semestreFounded);
			return 1;
		}
		
	}

	
		
	}

	


