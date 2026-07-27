package com.empresa.service;


import java.util.List;
import com.empresa.entity.Plato;
import com.empresa.repository.PlatoRepository;

public interface PlatoService {
    public abstract List<Plato> listaPorNombre(String filtro);
    public abstract Plato insertaPlato(Plato obj);
    public abstract void eliminaPlato(int id);
    public abstract List<Plato> listaPorCategoria(String categoria);
    public abstract List<Plato> listaPorCategoriaYNivelPicante(String categoria, String nivelPicante);
    
    
    
    
}
