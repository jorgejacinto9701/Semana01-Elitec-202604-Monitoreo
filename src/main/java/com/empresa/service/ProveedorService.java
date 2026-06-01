package com.empresa.service;

import com.empresa.entity.Proveedor;

import java.util.List;

public interface ProveedorService {

    public abstract List<Proveedor> listaTodos();
    public abstract Proveedor insertaProveedor(Proveedor obj);
    public abstract List<Proveedor> consultaDinamica(String nombre, String dni, int pais, int tipo, int estado);

}
