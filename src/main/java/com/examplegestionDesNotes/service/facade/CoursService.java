package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Cours;
import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.bean.Module;

public interface CoursService {
public List<Cours> findAll();
public int save(Cours cours);
public int deleteByModuleNom(String nom);

}
