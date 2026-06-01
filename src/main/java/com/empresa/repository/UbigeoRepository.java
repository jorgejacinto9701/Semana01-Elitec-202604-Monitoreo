package com.empresa.repository;

import com.empresa.entity.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Integer> {


    @Query("select distinct e.departamento from Ubigeo e")
    public abstract List<String> listaDepartamento();

    @Query("select distinct e.provincia from Ubigeo e where e.departamento = ?1")
    public abstract List<String> listaProvincia(String departamento);

    @Query("select e from Ubigeo e  where e.departamento = ?1 and  e.provincia = ?2")
    public abstract List<Ubigeo> listaDistrito(String departamento, String provincia);
}
