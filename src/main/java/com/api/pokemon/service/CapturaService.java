package com.api.pokemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pokemon.entities.Captura;
import com.api.pokemon.entities.Entrenador;
import com.api.pokemon.repository.CapturaRepository;

@Service
public class CapturaService {

	@Autowired
	private CapturaRepository capturaRepository;

	public List<Captura> buscarPorEntrenador(Entrenador entrenador){
		return capturaRepository.findByEntrenador(entrenador);
	}

}
