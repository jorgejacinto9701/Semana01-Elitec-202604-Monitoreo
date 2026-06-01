package com.empresa.service;

import com.empresa.entity.Ubigeo;

import java.util.List;

public interface UbigeoService {

    public abstract List<String> listaDepartamento();
    public abstract List<String> listaProvincia(String departamento);
    public abstract List<Ubigeo> listaDistrito(String departamento, String provincia);




}
