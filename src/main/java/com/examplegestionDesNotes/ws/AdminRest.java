package com.examplegestionDesNotes.ws;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplegestionDesNotes.bean.Admin;
import com.examplegestionDesNotes.dao.AdminDao;
import com.examplegestionDesNotes.service.facade.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("cette classe admin")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("gestionDesNotes/admin")
public class AdminRest {
@Autowired
public AdminService adminService;
@Autowired
public AdminDao admindao;
@ApiOperation("save un admin")
@PostMapping("/")
public int save(@RequestBody Admin admin) {
	return adminService.save(admin);
}
@ApiOperation("trouver un admin à partir de login")
@GetMapping("/login/{login}")
public Admin findByLogin(@PathVariable String login) {
	return adminService.findByLogin(login);
}

@ApiOperation("findAll")
@GetMapping("/")
public List<Admin> findAll() {
	return adminService.findAll();
}
@ApiOperation("vérification déauthentification")
@GetMapping("/login/{login}/motDePasse/{motDePasse}")
public int findByLoginAndmotDePasse(@PathVariable String login,@PathVariable String motDePasse) {
	return adminService.findByLoginAndmotDePasse(login, motDePasse);
}
@ApiOperation("modifier login")
@GetMapping("/login1/{login1}/motDePasse/{motDePasse}/login2/{login2}")
public int updateLogin(@PathVariable String login1,@PathVariable String motDePasse,@PathVariable String login2) {
	return adminService.updateLogin(login1, motDePasse, login2);
}
@ApiOperation("modifier le mot de passe")
@GetMapping("/login/{login}/motDePasse/{motDePasse}/motDePasse2/{motDePasse2}/motDePasse3/{motDePasse3}")
public int updateMotDePass(@PathVariable String login,@PathVariable String motDePasse,@PathVariable String motDePasse2,@PathVariable String motDePasse3) {
	return adminService.updateMotDePass(login, motDePasse, motDePasse2, motDePasse3);
}
@ApiOperation("envoyer une notification")
@GetMapping("/destinataire/{destinataire}/subject/{subject}/text/{text}")
public int sendEmail(@PathVariable String destinataire,@PathVariable String subject,@PathVariable String text) {
	return adminService.sendEmail(destinataire, subject, text);
}
}