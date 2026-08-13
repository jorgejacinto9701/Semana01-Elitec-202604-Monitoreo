package com.empresa.repository;

import com.empresa.entity.Docente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	
	//JPQL: Java Persistence Query Language
	//Query con clases y atributos
	@Query("select d from Docente d where d.ubigeo.departamento = :dep and d.ubigeo.provincia = :pro and d.ubigeo.distrito = :dist")
	public List<Docente> listaPorDepProDist(String dep, String pro, String dist);
}
