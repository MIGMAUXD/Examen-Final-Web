package com.api.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pokemon.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;

}
