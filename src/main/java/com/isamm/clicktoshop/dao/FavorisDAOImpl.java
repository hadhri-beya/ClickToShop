package com.isamm.clicktoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.User;

public class FavorisDAOImpl implements IDAO<Favoris> {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Long create(Favoris obj) {
		em.persist(obj);
		return obj.getId().getIdProduit();
	}

	@Override
	public List<Favoris> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favoris> produitsParAttribut(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favoris> produitsParBoutique(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Favoris obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Favoris getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favoris> myListProducts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Favoris paniermyproduct(Long id, Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favoris> myListProductsPanier(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favoris> myListProductsFavoris(Long id) {
		Query req=em.createQuery("select fa from Favoris fa where fa.user.iduser =:x");
		req.setParameter("x", id);
		return  req.getResultList();
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
	public List<Produit> filterProduit(String cat, double prix, String bou) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
