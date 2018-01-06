package com.isamm.clicktoshop.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Panier {
	@EmbeddedId
	private IdPanier id = new IdPanier();
	
	@ManyToOne
	@JoinColumn(name = "iduser" , insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idProduit" , insertable = false, updatable = false)
	private Produit produit;
	
	private int quantite;
	
	
	
	public IdPanier getId() {
		return id;
	}

	public void setId(IdPanier id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panier(User user, Produit produit) {
		super();
		this.user = user;
		this.produit = produit;
	}
	
	
	
	

}
