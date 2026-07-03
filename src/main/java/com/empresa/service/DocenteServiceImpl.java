package com.empresa.service;

import com.empresa.entity.Docente;
import com.empresa.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements  DocenteService{

    @Autowired
    private DocenteRepository repository;

    @Override
    public Docente insertaDocente(Docente obj) {
        return repository.save(obj);
    }
}
