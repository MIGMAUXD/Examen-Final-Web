package com.api.pokemon.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tipo_pokemon")
public class TipoPokemon {

	@Id
	@SequenceGenerator(name = "tipoPokemon_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoPokemon_id_seq")
	private Integer id;
	private String descripcion;
	private String uuid;
	
}
