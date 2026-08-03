package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Libro;

public interface LibroRepository  extends JpaRepository<Libro, Integer> {

    @Query("select e from Libro e where LOWER(e.titulo) like ?1 ")
    public List<Libro> consultaDinamica(String titulo);
}
