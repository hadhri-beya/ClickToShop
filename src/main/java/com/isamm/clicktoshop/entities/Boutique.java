package com.isamm.clicktoshop.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Boutique {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBoutique;
	private String nomBoutique;
	private String adresseBoutique;
	private Long telBoutique;
	@OneToOne
	@JoinColumn(name = "vendeur")
	private User vendeur;
	
	@OneToMany(mappedBy="boutique")
	private Collection<Produit> produits ;

	public Boutique() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getIdBoutique() {
		return idBoutique;
	}



	public void setIdBoutique(Long idBoutique) {
		this.idBoutique = idBoutique;
	}



	public User getVendeur() {
		return vendeur;
	}

	public void setVendeur(User vendeur) {
		this.vendeur = vendeur;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}



	public String getNomBoutique() {
		return nomBoutique;
	}



	public void setNomBoutique(String nomBoutique) {
		this.nomBoutique = nomBoutique;
	}



	public String getAdresseBoutique() {
		return adresseBoutique;
	}



	public void setAdresseBoutique(String adresseBoutique) {
		this.adresseBoutique = adresseBoutique;
	}






	public Boutique(String nomBoutique, String adresseBoutique, Long telBoutique, User vendeur) {
		super();
		this.nomBoutique = nomBoutique;
		this.adresseBoutique = adresseBoutique;
		this.telBoutique = telBoutique;
		this.vendeur = vendeur;
	}



	public Long getTelBoutique() {
		return telBoutique;
	}



	public void setTelBoutique(Long telBoutique) {
		this.telBoutique = telBoutique;
	}
	
	
	
	
	
}
