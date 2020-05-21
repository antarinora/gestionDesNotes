package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
public Admin findByLogin(String login);
}
