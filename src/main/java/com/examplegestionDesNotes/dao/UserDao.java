package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.User;
@Repository
public interface UserDao  extends JpaRepository<User, Long>{
	public User findUserById(Long id);
	public User findUserByNom(String nom);
	public User findUserByEmail(String email);

}
