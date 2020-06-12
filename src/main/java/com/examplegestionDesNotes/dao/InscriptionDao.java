package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Inscription;

@Repository
public  interface InscriptionDao extends JpaRepository<Inscription, Long> {

}
