package com.api.pokemon.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Captura {
	
	@OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL)
	@JoinColumn(name="pokemon_id")
	private Set<Pokemon> pokemonId = new HashSet<>();
	
	@OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
	@JoinColumn(name="entrenador_id")
	private Set<Pokemon> entrenadorId = new HashSet<>();

}
