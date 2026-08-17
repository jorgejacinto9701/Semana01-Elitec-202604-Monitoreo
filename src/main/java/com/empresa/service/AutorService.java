package com.empresa.service;

import java.util.List;

import com.empresa.entity.Autor;

public interface AutorService {

	List<Autor> buscarPorNombresYApellidos(String nombres, String apellidos);

}