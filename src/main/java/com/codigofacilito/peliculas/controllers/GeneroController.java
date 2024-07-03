package com.codigofacilito.peliculas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codigofacilito.peliculas.dao.IGeneroRepository;
import com.codigofacilito.peliculas.entities.Genero;

@RestController
public class GeneroController {

	private IGeneroRepository generoRepository;

	public GeneroController(IGeneroRepository generoRepository) {
		this.generoRepository = generoRepository;
	}

	@PostMapping("genero")
	public Long guardar(@RequestParam String nombre) {
		Genero genero = new Genero();
		genero.setNombre(nombre);

		generoRepository.save(genero);

		return genero.getId();
	}

	@GetMapping("genero/{id}")
	public String buscarPorId(@PathVariable(name = "id") Long id) {
		return generoRepository.findById(id).getNombre();
	}
}
