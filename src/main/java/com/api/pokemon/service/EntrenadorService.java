package com.api.pokemon.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pokemon.entities.Entrenador;
import com.api.pokemon.repository.EntrenadorRepository;


@Service
public class EntrenadorService {

	@Autowired
	private EntrenadorRepository entrenadorRepository;
	
	
	public Optional<Entrenador> buscarPorEmail(String email) {
        return entrenadorRepository.findByEmail(email);
    }
	
	public Entrenador buscarPorUuid(String uuid) {
        return entrenadorRepository.findByUuid(uuid);
    }

		
}
