package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Plato;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlatoRepository  extends JpaRepository<Plato, Integer> {

    @Query("select e from Plato e where LOWER(e.nombre) like ?1 ")
    public List<Plato> consultaDinamica(String nombre);
}
