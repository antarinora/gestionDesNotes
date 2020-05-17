package com.examplegestionDesNotes.service;

import java.util.List;

import com.examplegestionDesNotes.bean.ModuleFiliere;

public interface ModuleFiliereService {
public List<ModuleFiliere>findAll();
public int save(ModuleFiliere moduleFiliere);
}
