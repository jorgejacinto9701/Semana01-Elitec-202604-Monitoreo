package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.empresa.entity.Libro;
import com.empresa.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository repository;

    @Override
    public List<Libro> listaPorTitulo(String filtro) {
        return repository.buscaPorLibro(filtro);
    }
    
    @Override
    public List<Libro> listaPorTituloYAutor(String titulo, String autor) {
        return repository.buscarPorTituloYAutor(titulo, autor);
    }


    @Override
    public Libro insertaLibro(Libro obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaLibro(int id) {
        repository.deleteById(id);
    }

}
