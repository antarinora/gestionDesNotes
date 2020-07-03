package com.examplegestionDesNotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examplegestionDesNotes.bean.Admin;


@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {

	Admin findByLogin(String login);
	@Query(nativeQuery = true, value = "SELECT email FROM `admin` WHERE login  =:login ")
	String  getadminbylogin(@Param("login") String login);

}
