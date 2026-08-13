package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;

public interface DocenteService {

    public abstract Docente insertaDocente(Docente obj);
    public abstract List<Docente> listaPorDepProDist(String dep, String pro, String dist);
    
}
