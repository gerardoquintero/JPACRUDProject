package com.skilldistillery.pokemon.data;

import java.util.List;

import com.skilldistillery.pokemon.entities.Pokemon;

public interface PokemonDAO {
	Pokemon findById(int pokemonId);
	List<Pokemon> findAll();
	Pokemon create(Pokemon pokemon);
	Pokemon update(int pokemonId, Pokemon pokemon);
	boolean deleteById(int pokemonId);
}
