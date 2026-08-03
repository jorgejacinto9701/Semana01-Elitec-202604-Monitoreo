package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
	//METODOS DE BUSQUEDA O FILTRACION


	// 1. Lista todos ordenados por la columna nombres
    public abstract List<Docente> findByOrderByNombresAsc();

   /* // 2. Este método busca por DNI usando una consulta JPQL personalizada
    @Query("select d from Docente d where d.dni = :filtro")
    public abstract List<Docente> listaPorDNI(@Param("filtro") String dni);*/

    // 3.Este metodo usa lower y concat para que busque coincidencias sin importar mayúsculas/minúsculas de nombre y apellido:

    @Query("select d from Docente d where lower(d.nombres) like lower(concat('%', :filtro, '%'))")
    public abstract List<Docente> listaPorNombre(@Param("filtro") String filtro);


    // 4.este metodo usa búsqueda de docentes por Ubigeo(implementar una búsqueda por la localización del docente)
    @Query("select d from Docente d where d.ubigeo.idubigeo = :idUbigeo")
    public abstract List<Docente> listaDocentePorUbigeo(@Param("idUbigeo") int idUbigeo);

 // Consulta en JPQL usando dos campos (nombres e idubigeo)
    @Query("SELECT d FROM Docente d WHERE d.nombres LIKE :nombre AND d.ubigeo.idubigeo = :ubigeo")
    public List<Docente> listaPorNombreAndUbigeo(String nombre, Integer ubigeo);

}// fin de la Public interfaace