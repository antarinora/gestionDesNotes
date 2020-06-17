package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Departement;

public interface DeparetementService {
public int save(Departement departement);
public Departement findByNom(String nom);
public List<Departement> findAll();
public int updateDepatement(Departement departement);
public int deleteByCode(String code);
public int departementTotale();
}
