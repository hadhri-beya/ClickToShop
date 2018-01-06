package com.isamm.clicktoshop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.User;
import com.isamm.clicktoshop.metier.IUserMetier;
import com.isamm.clicktoshop.metier.IVendeurMetier;



@Controller
@RequestMapping("/Vendeur")
@SessionAttributes({"editedProd","user"})
public class VendeurController {
	@Autowired
	private IVendeurMetier metierVendeur;
	@Autowired
	private IUserMetier metierUser;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metierVendeur.listproduits());
		return "produits";
	}
	
	@RequestMapping("/myShop")
	public String myShop(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<Panier> panier = null ;
		try {
			panier = metierVendeur.getPanier(metierUser.getUserByUsername(username).getIduser());
			System.out.println(panier.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		model.addAttribute("boutique", metierUser.getUserByUsername(username).getBoutique());
		model.addAttribute("produits", metierVendeur.myProducts(metierUser.getUserByUsername(username).getIduser()));
		model.addAttribute("categories", metierVendeur.allCategorie());
		model.addAttribute("boutiques", metierVendeur.allBoutique());
		model.addAttribute("panier", panier);
		
		
		
		return "Myshop";
	}
	
	@RequestMapping("/saveProd")
	public String saveCat(@Valid Produit p, BindingResult bindingResult, Model model,MultipartFile file)
			throws IOException {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("produits", metierVendeur.listproduits());
			return "AjoutProduit";
		}
		if (!file.isEmpty()) {
			p.setPhoto(file.getBytes());
		} else {
			if (p.getIdProduit() != null) {
				Produit cat = (Produit) model.asMap().get("editedProd");
				p.setPhoto(cat.getPhoto());
			}
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		p.setBoutique(metierUser.getUserByUsername(username).getBoutique());
		if (p.getIdProduit() == null)
			
		{	
			metierVendeur.ajouterProduit(p);
		}
		else
			{
			metierVendeur.modifierProduit(p);
			}
		return  "redirect:/Vendeur/myShop";
	}

	@RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idProd) throws IOException {
		Produit p = metierVendeur.getProduit(idProd);
		System.out.println(p.getPhoto() == null);
		if (p.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}

	@RequestMapping(value = "/editProd")
	public String editCat(Long idProd, Model model) {
		Produit p = metierVendeur.getProduit(idProd);
		model.addAttribute("categories", metierVendeur.allCategorie());
		model.addAttribute("editedProd", p);
		model.addAttribute("produit", p);
		
		return "AjoutProduit";
	}
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		Produit produit = new Produit();
		model.addAttribute("categories", metierVendeur.allCategorie());
		model.addAttribute("produit", produit);
		return "AjoutProduit";
		
	}
	
	@RequestMapping(value = "/suppProd")
	public String suppCat(Long idProd, Model model) {
		metierVendeur.supprimerProduit(idProd);
		return  "redirect:/Vendeur/myShop";
	}

	
	

}
