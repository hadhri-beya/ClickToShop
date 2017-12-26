package com.isamm.clicktoshop.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.clicktoshop.entities.Produit;

public class ProduitDAOImpl implements IDAO<Produit> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long create(Produit obj) {
		em.persist(obj);
		return obj.getIdproduit();
	}

	@Override
	public List<Produit> getAll() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public boolean delete(Long id) {
		Produit p=getById(id);
		try {
			em.remove(p);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public boolean update(Produit obj) {
		try {
			em.merge(obj);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public Produit getById(Long id) {
		return em.find(Produit.class, id);
	}

	public List<Produit> produitsParMotCle(String mc) {
		Query req=em.createQuery("select p from Produit p where p.designation like:x or p.description like:x");
				req.setParameter("x", "%"+mc+"%");
				return req.getResultList();
	}

	public List<Produit> produitsParCategorie(Long idCat) {
		Query req=em.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
				req.setParameter("x", idCat);
				return req.getResultList();
	}


	public List<Produit> produitsSelectionnes() {
		Query req=em.createQuery("select p from Produit p where p.selected=true");
				return req.getResultList();
	}

}
