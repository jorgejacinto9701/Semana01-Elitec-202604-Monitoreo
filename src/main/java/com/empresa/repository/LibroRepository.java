package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Libro;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository  extends JpaRepository<Libro, Integer> {

    @Query("select e from Libro e where LOWER(e.titulo) like ?1 ")
    public List<Libro> consultaDinamica(String titulo);
}
