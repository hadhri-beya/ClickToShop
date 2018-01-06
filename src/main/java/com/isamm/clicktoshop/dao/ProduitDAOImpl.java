package com.isamm.clicktoshop.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.IdPanier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.User;

public class ProduitDAOImpl implements IDAO<Produit> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long create(Produit obj) {
		em.persist(obj);
		return obj.getIdProduit();
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
	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req=em.createQuery("select p from Produit p where p.designation like:x or p.boutique.nomBoutique like:x");
				req.setParameter("x", "%"+mc+"%");
				return req.getResultList();
	}
	@Override
	public List<Produit> produitsParAttribut(Long idCat) {
		Query req=em.createQuery("select p from Produit p where p.categorie.idcategorie=:x");
				req.setParameter("x", idCat);
				return req.getResultList();
	}


	public List<Produit> produitsMulticritere (double prix , Long idCategorie , Long idBoutique) {
		Query req=em.createQuery("");
		req.setParameter("x", prix);
		req.setParameter("y", idCategorie);
		req.setParameter("z", idBoutique);
				return req.getResultList();
	}
	
	public List<Produit> myListProducts(Long idV) {
		Query req=em.createQuery("select p from Produit p where p.boutique.vendeur.iduser=:x");
				req.setParameter("x", idV);
				return req.getResultList();
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit paniermyproduct(Long id, Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> produitsParBoutique(Long id) {
		System.out.println(id);
		Query req=em.createQuery("select p from Produit p where p.boutique.idBoutique=:x");
		req.setParameter("x", id);
		return req.getResultList();
	}

	@Override
	public List<Produit> myListProductsPanier(Long id) {
		Query req=em.createQuery("select pa.produit from Panier pa where pa.user.iduser=:x ");
		req.setParameter("x", id);
		return (List<Produit>) req.getResultList();
	}

	@Override
	public boolean deletePanier(Long id, Long iduser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Favoris> myListProductsFavoris(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> filterProduit(String cat, double prix, String bou) {
		Query req=em.createQuery("select p from Produit p where p.boutique.nomBoutique =:x"
				+ " and p.categorie.nomCategorie =:y and p.prix <:z ");
		req.setParameter("x", bou);
		req.setParameter("y", cat);
		req.setParameter("z", prix);
		return req.getResultList();
	}


}
