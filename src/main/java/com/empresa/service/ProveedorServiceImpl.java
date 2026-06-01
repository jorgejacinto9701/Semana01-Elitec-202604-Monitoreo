package com.empresa.service;

import com.empresa.entity.Proveedor;
import com.empresa.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    private ProveedorRepository repository;

    @Override
    public List<Proveedor> listaTodos() {
        return repository.findAll();
    }

    @Override
    public Proveedor insertaProveedor(Proveedor obj) {
        return repository.save(obj);
    }

    @Override
    public List<Proveedor> consultaDinamica(String nombre, String dni, int pais, int tipo, int estado) {
        return repository.consultaDinamica(nombre, dni, pais,  tipo, estado);
    }


}
