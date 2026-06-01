package com.empresa.repository;

import com.empresa.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

    public List<Pais> findByOrderByNombreAsc();
}
