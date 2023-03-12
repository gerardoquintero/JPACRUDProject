package com.skilldistillery.pokemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.pokemon.data.PokemonDAO;
import com.skilldistillery.pokemon.entities.Pokemon;

@Controller
public class PokemonController {

	@Autowired
	private PokemonDAO pDao;

	@RequestMapping(path = { "/", "home.do" })
	public String goHome(Model model) {
		model.addAttribute("pokemons", pDao.findAll());
		return "home";
	}

	@RequestMapping(path = "createNewPokemon.do", method = RequestMethod.GET)
	public ModelAndView createNewPokemon(Pokemon pokemon) {
		ModelAndView mv = new ModelAndView();
		Pokemon p = pDao.create(pokemon);

		if (pokemon == null) {

		} else {
			mv.addObject("pokemon", p);
			mv.setViewName("result");
			return mv;
		}
		return mv;
	}

	@RequestMapping(path = "getSinglePokemon.do", method = RequestMethod.GET)
	public ModelAndView findById(int pokemonId) {
		ModelAndView mv = new ModelAndView();
		Pokemon p = pDao.findById(pokemonId);
		if (p == null) {

		} else {
			mv.addObject("Pokemon", p);
			mv.setViewName("result");
			return mv;
		}
		return mv;
	}

	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public ModelAndView updatePage(int pokemonId, Pokemon pokemon) {
		ModelAndView mv = new ModelAndView();
		Pokemon p = pDao.findById(pokemonId);
		mv.addObject("pokemon", p);
		mv.setViewName("updatePokemon");
		return mv;
	}

	@RequestMapping(path = "updatePokemon.do", method = RequestMethod.POST)
	public ModelAndView update(Pokemon pokemon) {
		ModelAndView mv = new ModelAndView();
		Pokemon pokemonEdited = pDao.update(0, pokemon);
		Pokemon reGetPokemon = pDao.findById(pokemonEdited.getId());
		if (!pokemonEdited.equals(null)) {
			mv.addObject("Pokemon", reGetPokemon);
			mv.setViewName("result");
			return mv;
		} else {
			return mv;
		}
	}    
}