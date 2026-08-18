package com.empresa.service;

import java.util.List;

import com.empresa.entity.Producto;

public interface ProductoService {

	List<Producto> listaPorCategoriaYPrecio(int idCategoria, double precio);

	List<Producto> listaPorCategoriaDescripcionYStock(String descripcion, int stock);

}