package com.api.pokemon.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entities.Captura;
import com.api.pokemon.entities.Entrenador;
import com.api.pokemon.entities.Pokemon;

public interface CapturaRepository extends JpaRepository<Captura, Integer>{

	List<Captura> findByEntrenador(Entrenador entrenadord);
	
	Boolean existsByEntrenadorAndPokemon(Entrenador entrenador, Pokemon pokemon);
}
