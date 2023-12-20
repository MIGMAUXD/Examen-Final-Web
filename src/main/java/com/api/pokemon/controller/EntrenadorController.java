package com.api.pokemon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokemon.entities.Captura;
import com.api.pokemon.entities.Entrenador;
import com.api.pokemon.entities.Pokemon;
import com.api.pokemon.repository.CapturaRepository;
import com.api.pokemon.service.CapturaService;
import com.api.pokemon.service.EntrenadorService;
import com.api.pokemon.service.PokemonService;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {

	@Autowired
	private EntrenadorService entrenadorService;

	@Autowired
	private CapturaService capturaService;
	
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private CapturaRepository capturaRepository;
	

	@PostMapping("/login")
	public ResponseEntity<?> buscarNombrePorEmail(@RequestBody Map<String, String> requestBody) {
		String email = requestBody.get("email");

		if (email != null && !email.isEmpty()) {
			Optional<Entrenador> entrenador = entrenadorService.buscarPorEmail(email);

			if (entrenador.isPresent()) {
				String uuid = entrenador.get().getUuid();
				return ResponseEntity.ok(uuid);
			} else {
				return ResponseEntity.notFound().build();
			}
		} else {
			return ResponseEntity.badRequest().body("El parámetro 'email' no puede estar vacío");
		}
	}

	@GetMapping("/{uuid}/pokemons")
	public ResponseEntity<List<Pokemon>> listarPokemonesDeEntrenador(@RequestParam String uuid) {
		Entrenador entrenador = entrenadorService.buscarPorUuid(uuid);

		if (entrenador == null) {
			return ResponseEntity.notFound().build();
		}

		List<Captura> capturas = capturaService.buscarPorEntrenador(entrenador);
		List<Pokemon> pokemones = capturas.stream().map(Captura::getPokemonId).collect(Collectors.toList());

		return ResponseEntity.ok(pokemones);
	}

	
	    
	@PostMapping("/{entrenadorUuid}/pokemons/{pokemonUuid}")
	public ResponseEntity<Map<String, String>> agregarPokemonAEntrenador(
	        @PathVariable("entrenadorUuid") String entrenadorUuid,
	        @PathVariable("pokemonUuid") String pokemonUuid
	) {
	    Entrenador entrenador = entrenadorService.buscarPorUuid(entrenadorUuid);
	    Pokemon pokemon = pokemonService.buscarPorUuidP(pokemonUuid);

	    if (entrenador == null || pokemon == null) {
	        return ResponseEntity.notFound().build();
	    }

	    // Verificar si el Pokemon ya está asociado al Entrenador
	    boolean yaAsociado = capturaRepository.existsByEntrenadorAndPokemon(entrenador, pokemon);

	    if (yaAsociado) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", "true");
	        errorResponse.put("message", "El pokemon ya está registrado al entrenador");
	        return ResponseEntity.badRequest().body(errorResponse);
	    }

	    Captura nuevaCaptura = new Captura();
	    nuevaCaptura.setEntrenadorId(entrenador);
	    nuevaCaptura.setPokemonId(pokemon);
	    capturaRepository.save(nuevaCaptura);

	    return ResponseEntity.ok().build();
	}


}
