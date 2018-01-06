package com.isamm.clicktoshop.metier;

import java.util.List;

import com.isamm.clicktoshop.entities.Boutique;
import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;

public interface IAcheteurMetier {
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsParBoutique(Long idBou);
	public List<Produit> filterProduit(String cat , double prix , String bou );
	public List<Produit> listproduits();
	public Produit getProduit(Long idP);
	public List<Panier> getPanier(Long idU);
	public Long addPanier(Panier panier);
	public boolean deletPanier(Long idproduit,Long iduser);
	public boolean editPanier(Panier panier);
	public Panier productPanier(long idUser , Long idProd);
	public List<Produit> productsPanier(long idUser);
	public List<Produit> produitsParMotCle(String mc);
	public Long addFavoris(Favoris favoris);
	List<Favoris> productsFavoris(long idUser);
}
