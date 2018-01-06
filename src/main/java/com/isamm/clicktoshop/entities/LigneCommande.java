package com.isamm.clicktoshop.entities;

import javax.persistence.*;

@Entity
public class LigneCommande {
	@EmbeddedId
	private Id id = new Id();
	@Column(name = "quantite")
	private float quantite;
	@ManyToOne
	@JoinColumn(name = "idcommande" , insertable = false, updatable = false)
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "idProduit" , insertable = false, updatable = false)
	private Produit produit;
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCommande(Id id, float quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}
	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
	public float getQuantite() {
		return quantite;
	}
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	

}
