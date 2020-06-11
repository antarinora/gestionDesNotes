package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.bean.Note;

public interface InscriptionService {
public int save(Inscription inscription);
public int updateInscription(Inscription inscription);
public int deleteByEtudiantCne(String cne);
public int saveInsc(Inscription inscription);
public List<Inscription>findAll();
}
