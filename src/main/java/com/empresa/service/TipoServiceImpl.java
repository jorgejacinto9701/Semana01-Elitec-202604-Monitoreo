package com.empresa.service;

import com.empresa.entity.Tipo;
import com.empresa.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoServiceImpl implements TipoService{

    @Autowired
    private TipoRepository repository;

    @Override
    public List<Tipo> listaTodos() {
        return repository.findAll();
    }
}
