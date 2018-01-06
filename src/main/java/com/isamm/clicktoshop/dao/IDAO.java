package com.isamm.clicktoshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.isamm.clicktoshop.entities.*;
public interface IDAO<T> {
	public abstract Long create(T obj);
	public abstract List<T> getAll();
	public abstract List<T> produitsParAttribut(Long id);
	public abstract List<T> produitsParBoutique(Long id);
	public abstract boolean delete(Long id);
	public abstract boolean update(T obj);
	public abstract T getById (Long id);
	public abstract List<T> myListProducts(Long id);
	public abstract User getUserByUsername(String username);
	public abstract T paniermyproduct(Long id, Long id2);
	public abstract List<T> myListProductsPanier(Long id);
	boolean deletePanier(Long id, Long iduser);
	List<Produit> produitsParMotCle(String mc);
	List<Produit> filterProduit(String cat , double prix , String bou);
	List<Favoris> myListProductsFavoris(Long id);
	
	
}
