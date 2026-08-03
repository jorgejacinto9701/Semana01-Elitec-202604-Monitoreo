package com.empresa.service;

import java.util.List;

import com.empresa.entity.Ubigeo;

public interface UbigeoService {

    public abstract List<String> listaDepartamento();
    public abstract List<String> listaProvincia(String departamento);
    public abstract List<Ubigeo> listaDistrito(String departamento, String provincia);




}
