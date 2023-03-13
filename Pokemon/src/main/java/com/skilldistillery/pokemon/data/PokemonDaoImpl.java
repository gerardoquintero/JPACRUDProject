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
		em.persist(pokemon);
		em.flush();
		return pokemon;
	}
	
	@Override
	public Pokemon update(int pokemonId, Pokemon pokemon) {
		Pokemon managedPokemon = em.find(Pokemon.class, pokemon.getId());
		
		if(managedPokemon != null) {
			managedPokemon.setId(pokemon.getId());
			managedPokemon.setName(pokemon.getName());
			managedPokemon.setDescription(pokemon.getDescription());
		}
		
		return managedPokemon;
	}

	@Override
	public boolean deleteById(int id) {
		Pokemon managedPokemon = em.find(Pokemon.class, id);
		
		if(managedPokemon != null) {
			em.remove(managedPokemon);			
		}
		
	    boolean wasDeleted = !em.contains(managedPokemon);
	    return wasDeleted;
	}	
}	
	


