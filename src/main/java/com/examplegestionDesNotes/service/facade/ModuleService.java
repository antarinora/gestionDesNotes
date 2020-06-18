package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Module;

public interface ModuleService {
public int save(Module module);
public Module findByNom(String nom);
public Module findByCode(String code);
public List<Module>findAll();
public List<Module> findByFiliereCode(String code);
public List<Module>findByEtudiantCne(String cne);
public List<Module>findBySemestreNom(String nom);
public List<Module>findByEtudiantCneAndSemestreNom(String cne,String nom);
public List<Module>findByEnseignantLogin(String login);
public int updateModule(Module module);
public int deleteByModuleNom(String nom);
public  int anne();
	


}
