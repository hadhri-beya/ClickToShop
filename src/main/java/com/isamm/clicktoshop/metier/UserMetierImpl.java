package com.isamm.clicktoshop.metier;

import org.springframework.transaction.annotation.Transactional;

import com.isamm.clicktoshop.dao.IDAO;
import com.isamm.clicktoshop.dao.UserDAOImpl;
import com.isamm.clicktoshop.entities.User;

@Transactional
public class UserMetierImpl implements IUserMetier{
	private IDAO<User> udao;
	

	public void setUdao(IDAO<User> udao) {
		this.udao = udao;
	}

	@Override
	public Long AddUser(User u) {
		return udao.create(u) ;
	}

	@Override
	public boolean deleteUser(Long idu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		return udao.update(u);
		
	}

	@Override
	public User getUserByUsername(String username) {
		return udao.getUserByUsername(username);
	}

	@Override
	public User getById(Long id) {
		return udao.getById(id);
	}

}
