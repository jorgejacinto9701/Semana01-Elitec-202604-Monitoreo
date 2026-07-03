package com.empresa.service;

import com.empresa.dto.ProveedorEstadoDTO;
import com.empresa.dto.ProveedorMesDTO;
import com.empresa.dto.ProveedorPaisDTO;
import com.empresa.dto.ProveedorTipoDTO;
import com.empresa.entity.Proveedor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorService {

    public abstract List<Proveedor> listaTodos();
    public abstract Proveedor insertaProveedor(Proveedor obj);
    public abstract List<Proveedor> consultaDinamica(String nombre, String dni, int pais, int tipo, int estado);
    public abstract void eliminaProveedor(int idProveedor);
    public abstract List<ProveedorPaisDTO> cantidadPorPais();
    public abstract List<ProveedorEstadoDTO> cantidadPorEstado();
    public abstract List<ProveedorTipoDTO> cantidadPorTipo();
    public abstract List<ProveedorMesDTO> cantidadPorMes();
}
