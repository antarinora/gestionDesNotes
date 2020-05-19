package com.examplegestionDesNotes.service;

import java.util.List;

import com.examplegestionDesNotes.bean.Cours;
import com.examplegestionDesNotes.bean.Enseignant;
import com.examplegestionDesNotes.bean.Module;

public interface CoursService {
public List<Cours> findAll();
public int save(Cours cours);
}
