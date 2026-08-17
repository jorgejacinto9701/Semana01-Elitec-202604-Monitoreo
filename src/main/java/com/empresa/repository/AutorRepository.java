package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empresa.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

	@Query("""
			SELECT a
			FROM Autor a
			WHERE LOWER(a.nombres) LIKE LOWER(CONCAT('%', :nombres, '%'))
			AND LOWER(a.apellidos) LIKE LOWER(CONCAT('%', :apellidos, '%'))
			ORDER BY a.idAutor
			""")
	List<Autor> buscarPorNombresYApellidos(
			@Param("nombres") String nombres,
			@Param("apellidos") String apellidos);

}