package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Cours;

public interface CoursService {
public List<Cours> findAll();
public int save(Cours cours);
public int updateCours(Cours cours);
public int deleteByModuleNom(String nom);

}
