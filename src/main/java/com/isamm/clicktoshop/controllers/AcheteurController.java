package com.isamm.clicktoshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isamm.clicktoshop.entities.Role;
import com.isamm.clicktoshop.entities.User;
import com.isamm.clicktoshop.metier.IUserMetier;


@Controller
@RequestMapping("/Acheteur")
public class AcheteurController {
	@Autowired
	private IUserMetier metierUser;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "acceuilAcheteur";
	}
	

	@RequestMapping("/profile")
	public String profile(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		model.addAttribute("user", metierUser.getUserByUsername(username));
		return "profile";
	}

}
