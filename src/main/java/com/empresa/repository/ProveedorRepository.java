package com.empresa.repository;

import com.empresa.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query("select e from Proveedor e where " +
            "LOWER(e.nombre) like ?1 and " +
            "(?2 ='-1' or e.dni = ?2 ) and " +
            "(?3 = -1 or e.pais.idPais = ?3) and" +
            "(?4 = -1 or e.tipo.idTipo = ?4) and " +
            "(?5 = -1 or e.estado = ?5 ) ")
    public List<Proveedor> consultaDinamica(String nombre, String dni, int pais, int tipo, int estado);
}
