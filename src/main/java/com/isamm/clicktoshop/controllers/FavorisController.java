package com.isamm.clicktoshop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.metier.IUserMetier;
import com.isamm.clicktoshop.metier.IVendeurMetier;

@Controller
@RequestMapping("/Acheteur")
public class FavorisController {
	@Autowired
	private IVendeurMetier metierVendeur;
	@Autowired
	private IUserMetier metierUser;
	
	@RequestMapping("/ajoutFavoris")
	public String ajoutFavoris( Model model,Long idProd) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Favoris f = new Favoris() ;
		f.getId().setIduser(metierUser.getUserByUsername(username).getIduser());
		f.getId().setIdProduit(metierVendeur.getProduit(idProd).getIdProduit());
		
			metierVendeur.addFavoris(f);
			return  "redirect:/";
	}
	
	@RequestMapping(value = "/photoFavoris", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idProd) throws IOException {
		Produit p = metierVendeur.getProduit(idProd);
		System.out.println(p.getPhoto() == null);
		if (p.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	@RequestMapping("/wishlist")
	public String wishlist( Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<Produit> produitspanier = null ;

		try {
			produitspanier = metierVendeur.productsPanier(metierUser.getUserByUsername(username).getIduser());} 
		catch (Exception e) {}
		
		List<Panier> panier = null ;

		try {
			panier = metierVendeur.getPanier(metierUser.getUserByUsername(username).getIduser());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		List<Favoris> favoris = null ;

		try {
			favoris = metierVendeur.productsFavoris(metierUser.getUserByUsername(username).getIduser());
	
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		model.addAttribute("favoris", favoris);
		model.addAttribute("panier", panier);
		model.addAttribute("produitspanier", produitspanier);
		model.addAttribute("categories", metierVendeur.allCategorie());
		model.addAttribute("boutiques", metierVendeur.allBoutique());
		return "wishlist";
	}
	

}
