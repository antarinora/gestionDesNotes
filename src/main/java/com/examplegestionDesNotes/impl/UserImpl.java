package com.examplegestionDesNotes.impl;
	import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.examplegestionDesNotes.bean.User;

	@Component
	public class UserImpl implements com.examplegestionDesNotes.dao.UserDao {

//		@Autowired
//		private SessionFactory sessionFactory;
		
		@PersistenceContext
		EntityManager em;

		public User findUserByNom(String nom) {
//			User userDetails = null;
//			Criteria criteria = em.createCriteria(User.class);
//			criteria.add(Restrictions.eq("nom", nom));
//			List entityList = criteria.list();
//			if(!entityList.isEmpty()) {
//				userDetails = (User) entityList.get(0);
//			}
//			return userDetails;
			return null;
		}
		
		public User findUserByEmail(String email) {
			TypedQuery<User> query = em.createQuery("From User u where u.email=:email", User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		}

		@Override
		public List<User> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<User> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<User> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends User> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends User> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteInBatch(Iterable<User> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public User getOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends User> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<User> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends User> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<User> findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(User entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends User> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends User> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends User> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends User> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public User findUserById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}


}
