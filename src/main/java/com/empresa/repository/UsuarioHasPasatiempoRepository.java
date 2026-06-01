package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.UsuarioHasPasatiempo;
import com.empresa.entity.UsuarioHasPasatiempoPK;

public interface UsuarioHasPasatiempoRepository extends JpaRepository<UsuarioHasPasatiempo, UsuarioHasPasatiempoPK>{

	
}
