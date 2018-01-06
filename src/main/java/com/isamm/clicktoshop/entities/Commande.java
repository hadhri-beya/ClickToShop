package com.isamm.clicktoshop.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idcommande;
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User acheteur;
	
	private int numCommande;


	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Commande(int numCommande) {
		super();
		this.numCommande = numCommande;
	}



	public int getNumCommande() {
		return numCommande;
	}



	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}



	public Long getIdcommande() {
		return idcommande;
	}



	public void setIdcommande(Long idcommande) {
		this.idcommande = idcommande;
	}



	public User getAcheteur() {
		return acheteur;
	}



	public void setAcheteur(User acheteur) {
		this.acheteur = acheteur;
	}






	
	

}
