package com.empresa.service;

import com.empresa.entity.Deporte;
import com.empresa.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServiceImpl implements DeporteService{

    @Autowired
    private DeporteRepository repository;

    @Override
    public List<Deporte> listaTodos() {
        return repository.findAll();
    }
}
