package com.isamm.clicktoshop.controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.BaseDigestPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.isamm.clicktoshop.entities.Panier;
import com.isamm.clicktoshop.entities.Produit;
import com.isamm.clicktoshop.entities.Role;
import com.isamm.clicktoshop.entities.User;
import com.isamm.clicktoshop.metier.IUserMetier;
import com.isamm.clicktoshop.metier.IVendeurMetier;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	private IUserMetier metierUser;
	@Autowired
	private IVendeurMetier metierVendeur;

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "inscription";
	}

	@RequestMapping(value = "/inscriptionV", method = RequestMethod.GET)
	public String showRegistrationForm1(WebRequest request, Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "inscriptionV";
	}
	
	
	

	@RequestMapping("/saveUser")
	public String saveCat(@Valid User u, BindingResult bindingResult, Model model) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", u);
			return "inscription";
		}
		
		if (u.getIduser()== null) {
			if (u.getRoles().iterator().next().getNomRole().equals("ROLE_Vendeur")) {
			Role role = new Role();
			role.setNomRole("ROLE_Acheteur");
			role.setUser(u);
			u.getRoles().add(role);

			u.getBoutique().setVendeur(u);
			}
		}
		
		  try {
			  MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(u.getPassword().getBytes());
	            //Get the hash's bytes
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            u.setPassword(sb.toString()); 
		    } catch (NoSuchAlgorithmException ex) { }
		  	if (u.getIduser()!= null) {
		  		u.setRoles(null);
		  		u.setRoles(metierUser.getById(u.getIduser()).getRoles());
		  		metierUser.updateUser(u);
		  		return  "redirect:/j_spring_security_logout";
			} else {
				metierUser.AddUser(u);
			}
		
		  	return "login";
	}

	@RequestMapping("/login")
	public String login(Model model) {

		model.addAttribute("categories", metierVendeur.allCategorie());
		return "login";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
	
	@RequestMapping(value= "/recherche" ,  method = RequestMethod.POST)
	public String recherche(HttpServletRequest request, Model model) throws IOException {
		 String motcle = request.getParameter("motcle");
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			List<Produit> produitspanier = null ;

			try {
				produitspanier = metierVendeur.productsPanier(metierUser.getUserByUsername(username).getIduser());} catch (Exception e) {}
			
			List<Panier> panier = null ;

			try {
				panier = metierVendeur.getPanier(metierUser.getUserByUsername(username).getIduser());
				System.out.println(panier.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
			model.addAttribute("panier", panier);
			model.addAttribute("produitspanier", produitspanier);
			model.addAttribute("produits", metierVendeur.produitsParMotCle(motcle));
			model.addAttribute("categories", metierVendeur.allCategorie());
			model.addAttribute("boutiques", metierVendeur.allBoutique());
			return "home";
	}
	

	@RequestMapping(value= "/filter" ,  method = RequestMethod.POST)
	public String filter(HttpServletRequest request, Model model) throws IOException {
		 String categorie = request.getParameter("categorie");
		 String boutique = request.getParameter("boutique"); 
		 String prix = request.getParameter("prix");
		 double p = Double.parseDouble(prix);
		 System.out.println(categorie);
		 System.out.println(boutique);
		 System.out.println(prix);
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			List<Produit> produitspanier = null ;

			try {
				produitspanier = metierVendeur.productsPanier(metierUser.getUserByUsername(username).getIduser());} catch (Exception e) {}
			
			List<Panier> panier = null ;

			try {
				panier = metierVendeur.getPanier(metierUser.getUserByUsername(username).getIduser());
				System.out.println(panier.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
			model.addAttribute("panier", panier);
			model.addAttribute("produitspanier", produitspanier);
			model.addAttribute("produits", metierVendeur.filterProduit(categorie , p , boutique));
			model.addAttribute("categories", metierVendeur.allCategorie());
			model.addAttribute("boutiques", metierVendeur.allBoutique());
			return "home";
	}
	
}