package com.isamm.clicktoshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.IdPanier;
import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.User;

public class PanierDAOImpl implements IDAO<Panier> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long create(Panier obj) {	
		em.persist(obj);
		return obj.getProduit().getIdProduit();
	}

	@Override
	public List<Panier> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePanier(Long idproduit , Long iduser) {
		IdPanier id = new IdPanier();
		Panier panier = new Panier();
		id.setIdProduit(idproduit);;
		id.setIduser(iduser);
		panier.setId(id);
		panier = em.find(Panier.class, id) ;
				
		try {
			em.remove(panier);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public boolean update(Panier obj) {
		try {
			em.merge(obj);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public Panier getById(Long id) {
		Query req=em.createQuery("select pa from Panier pa where pa.user.iduser=:x ");
		req.setParameter("x", id);
		return (Panier) req.getSingleResult();
	}

	@Override
	public List<Panier> myListProducts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panier paniermyproduct(Long id, Long id2) {
		Query req=em.createQuery("select p from Panier p where p.user.iduser=:x and p.produit.idProduit=:y  ");
		req.setParameter("x", id);
		req.setParameter("y", id2);
		return (Panier) req.getSingleResult();
	}

	@Override
	public List<Panier> produitsParAttribut(Long idCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Panier> produitsParBoutique(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Panier> myListProductsPanier(Long id) {
		Query req=em.createQuery("select pa from Panier pa where pa.user.iduser=:x ");
		req.setParameter("x", id);
		return (List<Panier>) req.getResultList();
		
	}

	@Override
	public boolean delete(Long id) {
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
