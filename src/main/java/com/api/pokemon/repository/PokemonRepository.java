package com.api.pokemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>{

	List<Pokemon> findByUuid(String uuid);
}
