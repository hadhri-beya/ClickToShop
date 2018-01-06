package com.isamm.clicktoshop.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Favoris {
	
	@EmbeddedId
	private IdFavoris id = new IdFavoris();
	
	@ManyToOne
	@JoinColumn(name = "iduser" , insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idProduit" , insertable = false, updatable = false)
	private Produit produit;
	
	public Favoris() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public IdFavoris getId() {
		return id;
	}



	public void setId(IdFavoris id) {
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

	public Favoris(User user, Produit produit) {
		super();
		this.user = user;
		this.produit = produit;
	}
	
	
	

}
