package com.isamm.clicktoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.isamm.clicktoshop.entities.Role;
import com.isamm.clicktoshop.entities.User;

public class UserDAOImpl implements IDAO<User>{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long create(User obj) {
		em.persist(obj);
		return obj.getIduser();
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
