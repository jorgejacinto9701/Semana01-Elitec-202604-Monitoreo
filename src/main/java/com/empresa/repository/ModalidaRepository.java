package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Modalidad;

public interface ModalidaRepository extends JpaRepository<Modalidad, Integer> {


    public List<Modalidad> findByNombreContaining(String filtro);
    public List<Modalidad> findBySede(String sede);

    @Query("select p from Modalidad p where p.deporte.idDeporte between  ?1 and ?2")
    public List<Modalidad> listaPorRangoDeporte(int deporteDesde, int deporteHasta);

    @Query("select p from Modalidad p where p.sede = ?1 and p.estado = ?2 and p.nombre = ?3")
    public List<Modalidad> listaGeneral(String sede, int estado, String nombre);


}
