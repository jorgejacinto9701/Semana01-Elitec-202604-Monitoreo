package com.empresa.service;

import com.empresa.dto.ProveedorEstadoDTO;
import com.empresa.dto.ProveedorMesDTO;
import com.empresa.dto.ProveedorPaisDTO;
import com.empresa.dto.ProveedorTipoDTO;
import com.empresa.entity.Alumno;
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

    @Override
    public void eliminaProveedor(int idProveedor) {
        repository.deleteById(idProveedor);
    }

    @Override
    public List<ProveedorPaisDTO> cantidadPorPais() {
        return repository.cantidadPorPais();
    }

    @Override
    public List<ProveedorEstadoDTO> cantidadPorEstado() {
        return repository.cantidadPorEstado();
    }

    @Override
    public List<ProveedorTipoDTO> cantidadPorTipo() {
        return repository.cantidadPorTipo();
    }

    @Override
    public List<ProveedorMesDTO> cantidadPorMes() {
        return repository.cantidadPorMes();
    }

	@Override
	public List<Proveedor> listaPorNombre(String nombre) {
		return repository.listaPorNombre(nombre);
	}
   
	
    
}  
