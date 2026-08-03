package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Docente;
import com.empresa.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

	//METODOS PARA INDICAR QUE LLAME AL REPOSITORIO
	@Autowired
    private DocenteRepository repository;

    @Override
    public List<Docente> listaTodos() {
        return repository.findByOrderByNombresAsc();
    }

    @Override
    public List<Docente> listaPorNombre(String filtro) {
        return repository.listaPorNombre(filtro);
    }

    /*@Override
    public List<Docente> listaPorDNI(String dni) {
        return repository.listaPorDNI(dni);
    }*/

    @Override
    public List<Docente> listaDocentePorUbigeo(int idUbigeo) {
        return repository.listaDocentePorUbigeo(idUbigeo);
    }

    @Override
    public List<Docente> listaDocentesPorNombreYUbigeo(String nombre, Integer ubigeo) {
        return repository.listaPorNombreAndUbigeo(nombre, ubigeo);
    }


}// fin del public