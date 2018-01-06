package com.isamm.clicktoshop.metier;

import java.util.List;

import com.isamm.clicktoshop.entities.*;

public interface IVendeurMetier extends IAcheteurMetier {
	public Long ajouterProduit(Produit p);
	public boolean supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	public List<Produit> myProducts(Long idV);
	public List<Categorie> allCategorie();
	public List<Boutique> allBoutique();

}
