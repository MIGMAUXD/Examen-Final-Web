package com.api.pokemon.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Captura {
	
	@ManyToOne
	@JoinColumn(name="pokemon_id")
	private Pokemon pokemonId;
	
	@ManyToOne
	@JoinColumn(name="entrenador_id")
	private Entrenador entrenadorId;

}
