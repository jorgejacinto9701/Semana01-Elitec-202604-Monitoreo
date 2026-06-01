package com.empresa.service;

import com.empresa.entity.Modalidad;
import com.empresa.repository.ModalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidaServiceImpl implements  ModalidadService{

    @Autowired
    private ModalidaRepository modalidaRepository;

    @Override
    public List<Modalidad> listaTodos() {
        return modalidaRepository.findAll();
    }

    @Override
    public List<Modalidad> listaPorNombre(String filtro) {
        return modalidaRepository.findByNombreContaining(filtro);
    }

    @Override
    public Modalidad insertaModalidad(Modalidad obj) {
        return modalidaRepository.save(obj);
    }

    @Override
    public Modalidad actualizaModalidad(Modalidad obj) {
        return modalidaRepository.save(obj);
    }

    @Override
    public void eliminaModadlidad(int id) {
        modalidaRepository.deleteById(id);
    }

    @Override
    public Modalidad buscaModalidad(int id) {
        return modalidaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Modalidad> listaPorSede(String sede) {
        return modalidaRepository.findBySede(sede);
    }
    @Override
    public List<Modalidad> listaPorRangoDeporte(int deporteDesde, int deporteHasta) {
        return modalidaRepository.listaPorRangoDeporte(deporteDesde, deporteHasta);
    }

    @Override
    public List<Modalidad> listaGeneral(String sede, int estado, String nombre) {
        return modalidaRepository.listaGeneral(sede, estado,nombre);
    }

}
