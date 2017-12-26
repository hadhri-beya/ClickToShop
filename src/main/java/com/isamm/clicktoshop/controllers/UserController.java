package com.isamm.clicktoshop.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.isamm.clicktoshop.entities.Role;
import com.isamm.clicktoshop.entities.User;
import com.isamm.clicktoshop.metier.IUserMetier;

@Controller
public class UserController {
	@Autowired
	private IUserMetier metierUser;
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	    return "inscription";
	}
	
	@RequestMapping("/saveUser")
	public String saveCat(@Valid User u, BindingResult bindingResult, Model model)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", u);
			return "inscription";
		}
		 if (u.getRoles().iterator().next().getNomRole().equals("ROLE_Vendeur"))
		 {
			Role role = new Role();
			role.setNomRole("ROLE_Acheteur");
			role.setUser(u);
			u.getRoles().add(role);
		 }
		 metierUser.AddUser(u);
		return "inscription";
	}
	
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

}
}
