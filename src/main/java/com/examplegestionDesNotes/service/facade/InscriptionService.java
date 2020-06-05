package com.examplegestionDesNotes.service.facade;

import com.examplegestionDesNotes.bean.Inscription;
import com.examplegestionDesNotes.bean.Note;

public interface InscriptionService {
public int save(Inscription inscription);
public int updateInscription(Inscription inscription);
public int deleteByEtudiantCne(String cne);
}
