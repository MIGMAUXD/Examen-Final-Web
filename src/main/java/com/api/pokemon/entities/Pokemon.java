package com.api.pokemon.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pokemon {
	
	@Id
	@SequenceGenerator(name = "pokemon_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_id_seq")
	private Integer id;
	private String nombre;
	private String descripcion;
	@Column(name = "fecha_descubrimiento")
	private Date fechaDescubrimiento;
	private Integer generacion;
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name="tipo_pokemon")
	private TipoPokemon tipoPokemon;
	
	
	
}
