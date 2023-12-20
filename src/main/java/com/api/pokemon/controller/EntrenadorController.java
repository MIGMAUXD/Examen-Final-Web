package com.api.pokemon.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.pokemon.entities.Entrenador;
import com.api.pokemon.service.EntrenadorService;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {

	@Autowired
	private EntrenadorService entrenadorService;
	
	@PostMapping("/login")
	public ResponseEntity<?> buscarNombrePorEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");

        if (email != null && !email.isEmpty()) {
            Optional<Entrenador> entrenador = entrenadorService.buscarPorEmail(email);

            if (entrenador.isPresent()) {
                String uuid = entrenador.get().getUuid();
                return ResponseEntity.ok(uuid);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("El parámetro 'email' no puede estar vacío");
        }
    }
	
	
}
