package com.empresa.service;

import com.empresa.entity.Ubigeo;
import com.empresa.repository.UbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UbigeoServiceImpl implements  UbigeoService{

    @Autowired
    private UbigeoRepository repository;

    @Override
    public List<String> listaDepartamento() {
        return repository.listaDepartamento();
    }

    @Override
    public List<String> listaProvincia(String departamento) {
        return repository.listaProvincia(departamento);
    }

    @Override
    public List<Ubigeo> listaDistrito(String departamento, String provincia) {
        return repository.listaDistrito(departamento,provincia);
    }
}
