package com.examplegestionDesNotes.service;

import java.util.List;

import com.examplegestionDesNotes.bean.ModuleSemestre;

public interface ModuleSemestreService {
public List<ModuleSemestre>findAll();
public int save(ModuleSemestre moduleSemestre);
}