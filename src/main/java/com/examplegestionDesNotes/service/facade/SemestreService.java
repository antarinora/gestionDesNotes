package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Semestre;

public interface SemestreService {
public int save(Semestre semestre);
public Semestre findByNom(String nom);
public List<Semestre>findAll();
public List<Semestre>findByFiliereNom(String nom);
public List<Semestre>finByFiliereCodeAndEtudiantCne(String code,String cne);
public List<Semestre>findByModuleNom(String nom);
public int updateSemestre(Semestre semestre);
public int deleteByNom(String nom);
public int semestreTotale();
public int updatStatut(Semestre semestre,boolean statut);
}
