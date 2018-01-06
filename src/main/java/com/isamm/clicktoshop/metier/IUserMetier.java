package com.isamm.clicktoshop.metier;

import com.isamm.clicktoshop.entities.User;

public interface IUserMetier {
	public Long AddUser(User u);
	public boolean deleteUser(Long idu);
	public boolean updateUser(User u);
	public User getUserByUsername(String username);
	public User getById(Long id);
}
