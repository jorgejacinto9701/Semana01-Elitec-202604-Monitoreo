package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Producto;
import com.empresa.service.ProductoService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/producto")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProductoController {

	@Autowired
	private ProductoService service;

	@GetMapping("/porCategoriaYPrecio/{idCategoria}/{precio}")
	public ResponseEntity<List<Producto>> listaPorCategoriaYPrecio(
			@PathVariable int idCategoria,
			@PathVariable double precio) {

		List<Producto> lista = service.listaPorCategoriaYPrecio(idCategoria, precio);

		return ResponseEntity.ok(lista);
	}

	@GetMapping("/consulta")
	public ResponseEntity<List<Producto>> consulta(
			@RequestParam(name = "descripcion", required = true, defaultValue = "") String descripcion,
			@RequestParam(name = "stock", required = true, defaultValue = "-1") int stock) {

		List<Producto> lista = service.listaPorCategoriaDescripcionYStock(descripcion, stock);

		return ResponseEntity.ok(lista);
	}

}