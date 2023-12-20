package com.api.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokemon.entities.Pokemon;
import com.api.pokemon.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
 
	@GetMapping("/{tipo}")
    public ResponseEntity<?> listarPokemonesPorTipo(@RequestParam String tipo) {
        List<Pokemon> pokemons = pokemonService.buscarPorUuid(tipo);

        if (!pokemons.isEmpty()) {
            return ResponseEntity.ok(pokemons);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping
    public ResponseEntity<Pokemon> registrarPokemon(@RequestBody Pokemon pokemon) {
        Pokemon nuevoPokemon = pokemonService.registrarPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPokemon);
    }
	
    
}
