package com.isamm.clicktoshop.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.isamm.clicktoshop.dao.IDAO;
import com.isamm.clicktoshop.entities.Boutique;
import com.isamm.clicktoshop.entities.Categorie;
import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.IdFavoris;
import com.isamm.clicktoshop.entities.IdPanier;
import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;


@Transactional
public class ShopMetierImpl implements IVendeurMetier {
	private IDAO<Produit> pdao;
	private IDAO<Panier> panierdao;
	private IDAO<Categorie> categoriedao;
	private IDAO<Boutique> boutiquedao;
	private IDAO<Favoris> favorisdao;
	
	

	public void setFavorisdao(IDAO<Favoris> favorisdao) {
		this.favorisdao = favorisdao;
	}



	public void setPdao(IDAO<Produit> pdao) {
		this.pdao = pdao;
	}
	
	

	public void setPanierdao(IDAO<Panier> panierdao) {
		this.panierdao = panierdao;
	}

	

	public void setBoutiquedao(IDAO<Boutique> boutiquedao) {
		this.boutiquedao = boutiquedao;
	}



	public void setCategoriedao(IDAO<Categorie> categoriedao) {
		this.categoriedao = categoriedao;
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
	@Override
	public Produit getProduit(Long idP) {
		return pdao.getById(idP);
	}

	@Override
	public List<Produit> myProducts(Long idV) {
		return pdao.myListProducts(idV);
	}

	@Override
	public Long addPanier(Panier panier) {
		IdPanier id = new IdPanier();
		id.setIdProduit(panier.getProduit().getIdProduit());
		id.setIduser(panier.getUser().getIduser());
		panier.setId(id);
		return panierdao.create(panier);
	}



	@Override
	public Panier productPanier(long idUser, Long idProd) {
		
		return panierdao.paniermyproduct(idUser, idProd);
	}

	@Override
	public boolean editPanier(Panier panier) {
		IdPanier id = new IdPanier();
		id.setIdProduit(panier.getProduit().getIdProduit());
		id.setIduser(panier.getUser().getIduser());
		panier.setId(id);
		return panierdao.update(panier);
	}

	@Override
	public List<Categorie> allCategorie() {
		return categoriedao.getAll();
	}
	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return pdao.produitsParAttribut(idCat) ;
	}

	@Override
	public List<Boutique> allBoutique() {
		return boutiquedao.getAll();
	}



	@Override
	public List<Produit> produitsParBoutique(Long idBou) {
		// TODO Auto-generated method stub
		return pdao.produitsParBoutique(idBou) ;
	}



	@Override
	public List<Produit> productsPanier(long idUser) {
		return pdao.myListProductsPanier(idUser);
	}



	@Override
	public List<Panier> getPanier(Long idU) {
		// TODO Auto-generated method stub
		return panierdao.myListProductsPanier(idU);
	}



	@Override
	public boolean deletPanier(Long idproduit, Long iduser) {
		// TODO Auto-generated method stub
		return panierdao.deletePanier(idproduit, iduser);
	}



	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return pdao.produitsParMotCle(mc);
	}



	@Override
	public Long addFavoris(Favoris favoris) {
		
		
		return favorisdao.create(favoris);
	}
	@Override
	public List<Favoris> productsFavoris(long idUser) {
		return favorisdao.myListProductsFavoris(idUser);
	}



	@Override
	public List<Produit> filterProduit(String cat, double prix, String bou) {
		return pdao.filterProduit(cat, prix, bou) ;
	}
	
	
}
