package com.isamm.clicktoshop.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.metier.IVendeurMetier;


@Controller
@RequestMapping("/Vendeur")
public class VendeurController {
	@Autowired
	private IVendeurMetier metierVendeur;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metierVendeur.listproduits());
		return "produits";
	}
	
	@RequestMapping("/saveProd")
	public String saveCat(@Valid Produit p, BindingResult bindingResult, Model model)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("produits", metierVendeur.listproduits());
			return "produits";
		}
		metierVendeur.ajouterProduit(p);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metierVendeur.listproduits());
		return "produits";
	}
	
	@RequestMapping(value = "/suppProd")
	public String suppCat(Long idP, Model model) {
		metierVendeur.supprimerProduit(idP);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits",metierVendeur.listproduits());
		return "produits";
	}

	
	

}
