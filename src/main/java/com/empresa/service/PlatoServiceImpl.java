package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.empresa.entity.Plato;
import com.empresa.repository.PlatoRepository;

@Service
public class PlatoServiceImpl implements PlatoService{

    @Autowired
    private PlatoRepository repository;

    @Override
    public List<Plato> listaPorNombre(String filtro) {
        return repository.consultaDinamica(filtro);
    }

    @Override
    public Plato insertaPlato(Plato obj) {
        return repository.save(obj);
    }

    public void eliminaPlato(int id) {
        repository.deleteById(id);
    }
}
