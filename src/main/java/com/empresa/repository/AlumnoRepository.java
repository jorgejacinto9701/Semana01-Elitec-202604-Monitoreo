package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	public abstract List<Alumno> findByOrderByApellidosAsc();
	
	@Query("select e from Alumno e where e.dni = ?1")
	public abstract List<Alumno> listaPorDNI(String dni);
	
	//busqueda DNI + nombre del país
	@Query("select e from Alumno e where e.dni = ?1 and e.pais.nombre = ?2")
	public abstract List<Alumno> listaPorDniYPais(String dni, String nombrePais);
	
	
}//fin de la clase
