package com.empresa.service;

import com.empresa.entity.Modalidad;

import java.util.List;

public interface ModalidadService {

    public abstract List<Modalidad> listaTodos();
    public abstract List<Modalidad> listaPorNombre(String filtro);
    public abstract Modalidad insertaModalidad(Modalidad obj);
    public abstract Modalidad actualizaModalidad(Modalidad obj);
    public abstract void eliminaModadlidad(int id);
    public abstract Modalidad buscaModalidad(int id);

    public abstract List<Modalidad> listaPorSede(String sede);
    public abstract List<Modalidad> listaPorRangoDeporte(int deporteDesde, int deporteHasta);
    public abstract List<Modalidad> listaGeneral(String sede, int estado, String nombre);
}
