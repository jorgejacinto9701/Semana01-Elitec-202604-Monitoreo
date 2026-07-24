package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository  extends JpaRepository<Libro, Integer> {
	
	 public abstract List<Libro> findByOrderByTituloAsc();
	 

	 @Query("SELECT l FROM Libro l WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :texto, '%'))")
	 List<Libro> buscaPorLibro(@Param("texto") String texto);
	 
	 
	 @Query("SELECT l FROM Libro l "
	            + "WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')) "
	            + "AND LOWER(l.autor) LIKE LOWER(CONCAT('%', :autor, '%')) "
	            + "ORDER BY l.titulo ASC")
	    List<Libro> buscarPorTituloYAutor(
	            @Param("titulo") String titulo,
	            @Param("autor") String autor);
    
   
}