package com.api.pokemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entities.TipoPokemon;

public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Integer>{

	List<TipoPokemon> findByUuid(String uuid);
}
