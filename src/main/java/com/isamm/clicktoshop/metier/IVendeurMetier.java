package com.isamm.clicktoshop.metier;

import com.isamm.clicktoshop.entities.*;

public interface IVendeurMetier extends IAcheteurMetier {
	public Long ajouterProduit(Produit p);
	public boolean supprimerProduit(Long idP);
	public void modifierProduit(Produit p);

}
