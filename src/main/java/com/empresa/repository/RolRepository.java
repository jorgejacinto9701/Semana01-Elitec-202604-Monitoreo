// RolRepository.java
package com.empresa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombre(String nombre);
}