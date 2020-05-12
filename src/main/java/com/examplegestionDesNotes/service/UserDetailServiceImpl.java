package com.examplegestionDesNotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examplegestionDesNotes.bean.User;
import com.examplegestionDesNotes.dao.UserDao;
import com.examplegestionDesNotes.dtos.UserWrapper;

@Service("userDetailsService") 
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findUserByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found.");
		} 
		return new UserWrapper(user);
	}

}
