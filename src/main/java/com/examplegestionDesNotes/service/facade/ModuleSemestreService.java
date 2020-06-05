package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.ModuleSemestre;

public interface ModuleSemestreService {
public List<ModuleSemestre>findAll();
public int save(ModuleSemestre moduleSemestre);
public int updateModuleSemestre(ModuleSemestre moduleSemestre);
public int deleteByModuleNom(String nom);

}
