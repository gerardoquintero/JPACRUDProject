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
	private PokemonDAO pokemonDao;

	@RequestMapping(path = { "/", "home.do" })
	public String goHome(Model model) {
		model.addAttribute("pokemons", pokemonDao.findAll());
		return "home";
	}

	@RequestMapping(path = "createNewPokemon.do", method = RequestMethod.POST)
	public ModelAndView createNewPokemon(Pokemon pokemon) {
		ModelAndView mv = new ModelAndView();
		Pokemon p = pokemonDao.create(pokemon);

		if (pokemon == null) {

		} else {
			mv.addObject("Pokemon", p);
			mv.setViewName("result");
			return mv;
		}
		return mv;
	}

	@RequestMapping(path = "getSinglePokemon.do", method = RequestMethod.GET)
	public ModelAndView findById(int pokemonId) {
		ModelAndView mv = new ModelAndView();
		Pokemon p = pokemonDao.findById(pokemonId);
		if (p == null) {

		} else {
			mv.addObject("Pokemon", p);
			mv.setViewName("result");
			return mv;
		}
		return mv;
	}

	@RequestMapping(path = "goToCreatePokemon.do", method = RequestMethod.GET)
	public ModelAndView goToCreateNewPokemon() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createPokemon");
		return mv;
	}
	@RequestMapping(path = "goToUpdatePokemon.do", method = RequestMethod.POST)
	public ModelAndView goToUpdatePokemon(int id) {
		ModelAndView mv = new ModelAndView();
		Pokemon p = pokemonDao.findById(id);
		mv.addObject("pokemon", p);
		mv.setViewName("updatePokemon");
		return mv;
	}

	@RequestMapping(path = "updatePokemon.do", method = RequestMethod.POST)
	public ModelAndView update(Pokemon pokemon) {
		ModelAndView mv = new ModelAndView();
		Pokemon pokemonEdited = pokemonDao.update(pokemon.getId(), pokemon);
		Pokemon reGetPokemon = pokemonDao.findById(pokemonEdited.getId());
		if (!pokemonEdited.equals(null)) {
			mv.addObject("Pokemon", reGetPokemon);
			mv.setViewName("result");
			return mv;
		} else {
			return mv;
		}
	}

	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deletePokemon(int id) {
		ModelAndView mv = new ModelAndView();
		boolean isPokemonDeleted = pokemonDao.deleteById(id);
		if (isPokemonDeleted == true) {
			System.out.println(isPokemonDeleted);
			mv.addObject("isDeleted", true);
			mv.setViewName("result");
			return mv;
		} else {
			System.out.println(isPokemonDeleted);
			mv.addObject("notDeleted", true);
			mv.setViewName("result");
			return mv;
		}
	}
}