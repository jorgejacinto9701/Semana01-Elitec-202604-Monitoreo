package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Plato;

public interface PlatoRepository  extends JpaRepository<Plato, Integer> {

    @Query("select e from Plato e where LOWER(e.nombre) like ?1 ")
    public List<Plato> consultaDinamica(String nombre);
}
