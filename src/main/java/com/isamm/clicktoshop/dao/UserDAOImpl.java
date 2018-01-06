package com.isamm.clicktoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Produit;
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
		try {
			em.merge(obj);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public User getById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> myListProducts(Long id) {
		Query req=em.createQuery("select p from Produit p where p.boutique.vendeur=:x");
		req.setParameter("x", id);
		return req.getResultList();
	}
	@Override
	public User getUserByUsername(String username) {
		
		Query req=em.createQuery("select u from User u where u.username =:x");
		req.setParameter("x", username);
		return  (User) req.getSingleResult();
	}

	@Override
	public User paniermyproduct(Long id, Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> produitsParAttribut(Long idCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> produitsParBoutique(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> myListProductsPanier(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePanier(Long id, Long iduser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favoris> myListProductsFavoris(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> filterProduit(String cat, double prix, String bou) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
