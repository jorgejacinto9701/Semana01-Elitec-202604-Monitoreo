package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente; // Asegúrate de importar tu entidad Docente si está en otro paquete

public interface DocenteService {

	// SE DECLARA NUEVO METODOS PARA SABER QUE LA APLICAION SEPA QUE EXISTE


   // public abstract List<Docente> listaPorDNI(String dni);
    public abstract List<Docente> listaTodos();
    public abstract List<Docente> listaPorNombre(String filtro);
    public abstract List<Docente> listaDocentePorUbigeo(int idUbigeo);
    List<Docente> listaDocentesPorNombreYUbigeo(String nombre, Integer ubigeo);
}//fi de la interface
