package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Producto;
import com.empresa.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> listaPorCategoriaYPrecio(int idCategoria, double precio) {
		return repository.listaPorCategoriaYPrecio(idCategoria, precio);
	}

	@Override
	public List<Producto> listaPorCategoriaDescripcionYStock(String descripcion, int stock) {
		return repository.listaPorCategoriaDescripcionYStock(descripcion, stock);
	}

}