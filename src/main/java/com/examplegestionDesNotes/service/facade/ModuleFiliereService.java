package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.ModuleFiliere;

public interface ModuleFiliereService {
public List<ModuleFiliere>findAll();
public int updateModuleFiliere(ModuleFiliere moduleFiliere);
public int deleteByModuleNom(String nom);
public int save(ModuleFiliere moduleFiliere);
}
