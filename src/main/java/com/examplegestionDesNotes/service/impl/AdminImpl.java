package com.examplegestionDesNotes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.examplegestionDesNotes.bean.Admin;
import com.examplegestionDesNotes.dao.AdminDao;
import com.examplegestionDesNotes.service.facade.AdminService;
import com.examplegestionDesNotes.service.utils.PasswordUtils;

@Service
public class AdminImpl implements AdminService {
@Autowired
public AdminDao adminDao;
@Autowired
private JavaMailSender javaMailSender;

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

@Override
public int updateLogin(String login1, String motDePasse, String login2) {
	if(findByLoginAndmotDePasse(login1, motDePasse)==-1)
		return -1;
	else if(findByLoginAndmotDePasse(login1, motDePasse)==-2) {
		return -2;
	}else {
	Admin admin=findByLogin(login1);
		admin.setLogin(login2);
		adminDao.save(admin);
		return 1;
	}
}

@Override
public int updateMotDePass(String login, String motDePasse, String motDePasse2,String motDePasse3) {
	if(findByLoginAndmotDePasse(login, motDePasse)==-1)
		return -1;
	else if(findByLoginAndmotDePasse(login, motDePasse)==-2) {
		return -2;
	}else if(!motDePasse2.equals(motDePasse3)) {
		return -3;
	}
	else {
		Admin admin=findByLogin(login);
		String salt = admin.getSalt();
		 String Password = PasswordUtils.generateSecurePassword(motDePasse2, salt);
		 admin.setMotDePasse(Password);
      adminDao.save(admin);
      return 1;
		
}
}

@Override
public int sendEmail(String destinataire,String subject,String text) {
	SimpleMailMessage msg=new SimpleMailMessage();
	msg.setCc(destinataire);
	msg.setSubject(subject);
	msg.setText(text);
	javaMailSender.send(msg);
	return 1;
}

}
