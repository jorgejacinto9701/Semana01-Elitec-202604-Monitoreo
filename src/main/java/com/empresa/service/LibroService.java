package com.empresa.service;

import java.util.List;

import com.empresa.entity.Libro;

public interface LibroService {
    public abstract List<Libro> listaPorTitulo(String filtro);
    public abstract Libro insertaLibro(Libro obj);
    public abstract void eliminaLibro(int id);
}


