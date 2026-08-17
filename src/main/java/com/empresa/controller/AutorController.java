package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Autor;
import com.empresa.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping("/buscar/{nombres}/{apellidos}")
	public ResponseEntity<List<Autor>> buscarPathVariable(
			@PathVariable String nombres,
			@PathVariable String apellidos) {

		List<Autor> autores = autorService.buscarPorNombresYApellidos(
				nombres,
				apellidos);

		return ResponseEntity.ok(autores);
	}

}