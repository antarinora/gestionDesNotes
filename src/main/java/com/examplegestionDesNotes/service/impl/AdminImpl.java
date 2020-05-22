package com.examplegestionDesNotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Admin;
import com.examplegestionDesNotes.dao.AdminDao;
import com.examplegestionDesNotes.service.facade.AdminService;
import com.examplegestionDesNotes.service.utils.PasswordUtils;

@Service
public class AdminImpl implements AdminService {
@Autowired
public AdminDao adminDao;

@Override
public int save(Admin admin) {
	String salt = PasswordUtils.getSalt(30);
	 String Password = PasswordUtils.generateSecurePassword(admin.getMotDePasse(), salt);
	if(findByLogin(admin.getLogin())!=null)
		return -1;
	else {
		admin.setSalt(salt);
		admin.setMotDePasse(Password);
		adminDao.save(admin);
		return 1;
	}
}

@Override
public Admin findByLogin(String login) {
	return adminDao.findByLogin(login);
}

@Override
public List<Admin> findAll() {
	return adminDao.findAll();
}

@Override
public int findByLoginAndmotDePasse(String login, String motDePasse) {
	
	Admin admin= findByLogin(login);
	if(admin==null)
		return -1;
	else{
		String salt = admin.getSalt();
		if(PasswordUtils.verifyUserPassword(motDePasse, admin.getMotDePasse(), salt)) {
		
		return 1;
	}else {
		return -2;
	}
	}
	
}

}
