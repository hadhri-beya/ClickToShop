package com.isamm.clicktoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.clicktoshop.entities.Categorie;
import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.User;

public class CategorieDAOImpl implements IDAO<Categorie> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long create(Categorie obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAll() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> myListProducts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie paniermyproduct(Long id, Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> produitsParAttribut(Long idCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> produitsParBoutique(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> myListProductsPanier(Long id) {
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
