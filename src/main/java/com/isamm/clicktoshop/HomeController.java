package com.isamm.clicktoshop;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.isamm.clicktoshop.entities.Favoris;
import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.metier.IUserMetier;
import com.isamm.clicktoshop.metier.IVendeurMetier;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private IVendeurMetier metierVendeur;
	@Autowired
	private IUserMetier metierUser;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<Produit> produitspanier = null ;

		try {
			produitspanier = metierVendeur.productsPanier(metierUser.getUserByUsername(username).getIduser());} 
		catch (Exception e) {}
		
		List<Panier> panier = null ;

		try {
			panier = metierVendeur.getPanier(metierUser.getUserByUsername(username).getIduser());
			System.out.println(panier.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		List<Favoris> favoris = null ;

		try {
			favoris = metierVendeur.productsFavoris(metierUser.getUserByUsername(username).getIduser());
			System.out.println(favoris.size() + "drfffffffffffffffffff");
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		model.addAttribute("favoris", favoris);
		model.addAttribute("panier", panier);
		model.addAttribute("produitspanier", produitspanier);
		model.addAttribute("produits", metierVendeur.listproduits());
		model.addAttribute("categories", metierVendeur.allCategorie());
		model.addAttribute("boutiques", metierVendeur.allBoutique());
		return "home";
	}

	@RequestMapping(value = "/photoProdhome", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idProd) throws IOException {
		Produit p = metierVendeur.getProduit(idProd);
		System.out.println(p.getPhoto() == null);
		if (p.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}

	@RequestMapping(value = "/produitCategorie", method = RequestMethod.GET)
	public String produitCategorie(Long idCat, Model model) {

		model.addAttribute("produits", metierVendeur.produitsParCategorie(idCat));
		model.addAttribute("categories", metierVendeur.allCategorie());
		model.addAttribute("boutiques", metierVendeur.allBoutique());

		return "home";
	}

	@RequestMapping(value = "/produitBoutique", method = RequestMethod.GET)
	public String produitBoutiqu(Long idBou, Model model) {
		model.addAttribute("produits", metierVendeur.produitsParBoutique(idBou));
		model.addAttribute("boutiques", metierVendeur.allBoutique());
		model.addAttribute("categories", metierVendeur.allCategorie());
		return "home";
	}
	
	@RequestMapping(value = "/suppPanier")
	public String suppPanier(Long idProd, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		metierVendeur.deletPanier(idProd, metierUser.getUserByUsername(username).getIduser());
		return  "redirect:/";

	}

}
