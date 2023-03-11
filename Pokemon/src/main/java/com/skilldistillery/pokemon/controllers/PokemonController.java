package com.skilldistillery.pokemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.pokemon.data.PokemonDAO;

@Controller
public class PokemonController {
	
	@Autowired
	private PokemonDAO pDao;
	
	@RequestMapping(path = {"/", "home.do"})
	public String goHome(Model model) {
		model.addAttribute("pokemons", pDao.findAll());
		return "home";
	}

}
