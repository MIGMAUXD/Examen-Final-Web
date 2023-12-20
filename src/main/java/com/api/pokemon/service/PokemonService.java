package com.api.pokemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pokemon.entities.Pokemon;
import com.api.pokemon.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	public List<Pokemon> buscarPorUuid(String tipo){
		return pokemonRepository.findByUuid(tipo);
	}
	
	public Pokemon buscarPorUuidP(String tipo){
		
		return pokemonRepository.findByCodigo(tipo);
	}
	
	
	
	public Pokemon registrarPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
	
	

}
