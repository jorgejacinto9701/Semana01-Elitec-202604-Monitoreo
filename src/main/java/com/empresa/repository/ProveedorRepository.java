package com.empresa.repository;

import com.empresa.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.empresa.dto.ProveedorPaisDTO;
import com.empresa.dto.ProveedorEstadoDTO;
import com.empresa.dto.ProveedorTipoDTO;
import com.empresa.dto.ProveedorMesDTO;


public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query("select e from Proveedor e where " +
            "LOWER(e.nombre) like ?1 and " +
            "(?2 ='-1' or e.dni = ?2 ) and " +
            "(?3 = -1 or e.pais.idPais = ?3) and" +
            "(?4 = -1 or e.tipo.idTipo = ?4) and " +
            "(?5 = -1 or e.estado = ?5 )  order by e.idProveedor asc ")
    public List<Proveedor> consultaDinamica(String nombre, String dni, int pais, int tipo, int estado);

    @Query("SELECT new com.empresa.dto.ProveedorPaisDTO(p.pais.nombre, COUNT(p)) " +
            "FROM Proveedor p " +
            "GROUP BY p.pais.nombre " +
            "ORDER BY COUNT(p) DESC")
    public abstract List<ProveedorPaisDTO> cantidadPorPais();


    @Query("SELECT new com.empresa.dto.ProveedorEstadoDTO(" +
            "CASE WHEN p.estado = 1 THEN 'Activo' ELSE 'Inactivo' END, COUNT(p)) " +
            "FROM Proveedor p " +
            "GROUP BY p.estado")
    public abstract List<ProveedorEstadoDTO> cantidadPorEstado();


    @Query("SELECT new com.empresa.dto.ProveedorTipoDTO(p.tipo.descripcion, COUNT(p)) " +
            "FROM Proveedor p " +
            "GROUP BY p.tipo.descripcion " +
            "ORDER BY COUNT(p) DESC")
    public abstract List<ProveedorTipoDTO> cantidadPorTipo();


    @Query("SELECT new com.empresa.dto.ProveedorMesDTO(" +
            "CAST(FUNCTION('DATE_PART','month', p.fechaRegistro) AS string), COUNT(p)) " +
            "FROM Proveedor p " +
            "GROUP BY FUNCTION('DATE_PART','month', p.fechaRegistro) " +
            "ORDER BY FUNCTION('DATE_PART','month', p.fechaRegistro)")
    public abstract List<ProveedorMesDTO> cantidadPorMes();

}
