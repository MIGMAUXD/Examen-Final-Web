package com.api.pokemon.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pueblo {

	@Id
	@SequenceGenerator(name = "pueblo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pueblo_id_seq")
	private Integer id;
	private String nombre;
	private String uuid;
	
}
