package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("""
			SELECT p
			FROM Producto p
			WHERE p.categoria.idCategoria = :idCategoria
			AND p.precio >= :precio
			ORDER BY p.nombre
			""")
	List<Producto> listaPorCategoriaYPrecio(
			@Param("idCategoria") int idCategoria,
			@Param("precio") double precio);

	@Query("""
			SELECT p
			FROM Producto p
			WHERE LOWER(p.categoria.descripcion)
			LIKE LOWER(CONCAT('%', :descripcion, '%'))
			AND p.stock >= :stock
			ORDER BY p.nombre
			""")
	List<Producto> listaPorCategoriaDescripcionYStock(
			@Param("descripcion") String descripcion,
			@Param("stock") int stock);

}