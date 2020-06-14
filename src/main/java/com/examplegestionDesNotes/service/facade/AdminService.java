package com.examplegestionDesNotes.service.facade;

import java.util.List;

import com.examplegestionDesNotes.bean.Admin;

public interface AdminService {
public int save(Admin admin);
public Admin findByLogin(String login);
public List<Admin> findAll();
public int findByLoginAndmotDePasse(String login,String motDePasse);
public int updateLogin(String login1,String motDePasse,String login2);
public int updateMotDePass(String login,String motDePasse,String motDePasse2,String motDePasse3);
}
