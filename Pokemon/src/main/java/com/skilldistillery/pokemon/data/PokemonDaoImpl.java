package com.skilldistillery.pokemon.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.pokemon.entities.Pokemon;

	
	


@Service
@Transactional
public class PokemonDaoImpl implements PokemonDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Pokemon findById(int pokemonId) {

		return em.find(Pokemon.class, pokemonId);
	}

	@Override
	public List<Pokemon> findAll() {
		String jpql = "SELECT p FROM Pokemon p";
		return em.createQuery(jpql, Pokemon.class).getResultList();
	}

	

//	no begin/commit
//	no em. close 

	
	@Override
	public Pokemon create(Pokemon pokemon) {
//		String jpql = "INSERT p INTO Pokemon p";
//		Pokemon createdPokemon; 
////		= em.createQuery(pokemon); 
		return null;
//				createdPokemon;
	}
	
	@Override
	public Pokemon update(int pokemonId, Pokemon pokemon) {
		String jpql = "SELECT p FROM Pokemon WHERE id = ?";
		
		Pokemon managedPokemon = em.find(pokemon.getClass(), pokemonId);
		
		managedPokemon.setName(pokemon.getName());
		
		return managedPokemon;
	}

	@Override
	public boolean deleteById(int pokemonId) {
		boolean success = true;
		String jpql = "SELECT p FROM Pokemon WHERE id = ?";
		Pokemon deletedPokemon = em.find(Pokemon.class, pokemonId);
		
		if(em.contains(deletedPokemon)) {
			deletedPokemon.setId(pokemonId);
			em.remove(deletedPokemon);
			return success;
		} else {
		return false;
	   }
	}	
}	
	


