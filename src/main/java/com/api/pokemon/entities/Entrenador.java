package com.api.pokemon.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Entrenador {

	@Id
	@SequenceGenerator(name = "entrenador_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrenador_id_seq")
	private Integer id;
	private String nombre;
	private String apellido;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name = "fecha_vinculacion")
	private Date fechaVinculacion;
	@Column(name = "pueblo_id")
	private Integer puebloId;
	private String email;
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name="pueblo_id")
	private Pueblo pueblo;
	
	
}
