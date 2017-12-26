package com.isamm.clicktoshop.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.isamm.clicktoshop.dao.IDAO;
import com.isamm.clicktoshop.entities.Produit;


@Transactional
public class ShopMetierImpl implements IVendeurMetier {
	private IDAO<Produit> pdao;
	
	

	public void setPdao(IDAO<Produit> pdao) {
		this.pdao = pdao;
	}

	@Override
	public Long ajouterProduit(Produit p) {
		return pdao.create(p);
	}

	@Override
	public boolean supprimerProduit(Long idP) {
		return pdao.delete(idP);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		pdao.update(p);	
	}

	@Override
	public List<Produit> listproduits() {
		return pdao.getAll();
	}

}
