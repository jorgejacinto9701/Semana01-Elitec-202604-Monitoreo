package com.empresa.repository;

import com.empresa.entity.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

    public List<Pais> findByOrderByNombreAsc();

    @Query("""
            SELECT p
            FROM Pais p
            WHERE LOWER(p.iso) = LOWER(:iso)
            AND LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))
            ORDER BY p.nombre ASC
            """)
    public List<Pais> buscarPorIsoYNombre(
            @Param("iso") String iso,
            @Param("nombre") String nombre);

}