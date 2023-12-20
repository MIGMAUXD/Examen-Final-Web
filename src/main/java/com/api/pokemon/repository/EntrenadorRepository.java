package com.api.pokemon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pokemon.entities.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer>{

	Optional<Entrenador> findByEmail(String email);
	
	List<Entrenador> findByUuid(String uuid);
}
