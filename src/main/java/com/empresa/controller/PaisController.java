package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Pais;
import com.empresa.service.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisService paisService;

	@GetMapping("/buscar")
	public ResponseEntity<List<Pais>> buscarPais(
			@RequestParam String iso,
			@RequestParam String nombre) {

		List<Pais> paises = paisService.buscarPorIsoYNombre(
				iso,
				nombre);

		return ResponseEntity.ok(paises);
	}

}