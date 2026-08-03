package com.empresa.service;


import java.util.List;

import com.empresa.entity.Plato;

public interface PlatoService {
    public abstract List<Plato> listaPorNombre(String filtro);
    public abstract Plato insertaPlato(Plato obj);
    public abstract void eliminaPlato(int id);
}
