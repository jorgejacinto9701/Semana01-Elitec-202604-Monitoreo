package com.empresa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.empresa.entity.Cliente;

public interface ClienteService {

	public abstract List<Cliente> listaCliente(String filtro, Pageable ageable) ;
	
}
