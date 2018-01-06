package com.isamm.clicktoshop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.metier.IAcheteurMetier;
import com.isamm.clicktoshop.metier.IUserMetier;
import com.isamm.clicktoshop.metier.IVendeurMetier;

@Controller
@RequestMapping("/Acheteur")
public class PanierController {

	@Autowired
	private IVendeurMetier metierVendeur;
	@Autowired
	private IUserMetier metierUser;
	
	@RequestMapping("/indexPanier")
	public String indexPanier(Long idprod, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Produit p = metierVendeur.getProduit(idprod);
		Panier panier;
		try {
			panier = metierVendeur.productPanier(metierUser.getUserByUsername(username).getIduser(), idprod);

			model.addAttribute("panier", panier);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			model.addAttribute("panier",new Panier());
		}
		model.addAttribute("produit", p);
		return "ajoutPanier";
	}
	
	@RequestMapping(value = "/photoPanier", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idProd) throws IOException {
		Produit p = metierVendeur.getProduit(idProd);
		System.out.println(p.getPhoto() == null);
		if (p.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	@RequestMapping("/ajoutPanier")
	public String ajoutPanier(@Valid Panier p, BindingResult bindingResult, Model model,Long idProd) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		p.setUser( metierUser.getUserByUsername(username));
		p.setProduit(metierVendeur.getProduit(idProd));
		try {
			Panier panier = metierVendeur.productPanier(metierUser.getUserByUsername(username).getIduser(),
					idProd);
			metierVendeur.addPanier(p);
		} catch (Exception e) {
			metierVendeur.editPanier(p);
		}
		
		return  "redirect:/";
	}
	


}
