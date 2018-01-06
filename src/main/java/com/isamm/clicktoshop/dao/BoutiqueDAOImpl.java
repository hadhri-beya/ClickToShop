package com.isamm.clicktoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.clicktoshop.entities.Boutique;
import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.User;

public class BoutiqueDAOImpl implements IDAO<Boutique> {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Long create(Boutique obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutique> getAll() {
		Query req=em.createQuery("select b from Boutique b");
		return req.getResultList();
	}

	@Override
	public List<Boutique> produitsParAttribut(Long idBou) {
		return null ;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Boutique obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boutique getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutique> myListProducts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boutique paniermyproduct(Long id, Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutique> produitsParBoutique(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutique> myListProductsPanier(Long id) {
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
