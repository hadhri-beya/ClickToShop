package com.isamm.clicktoshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Acheteur")
public class AcheteurController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "acceuilAcheteur";
	}

}
