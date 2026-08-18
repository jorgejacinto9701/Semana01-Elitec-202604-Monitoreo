package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/alumno")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AlumnoController {

    @Autowired
    private AlumnoService service;
    
    
    @GetMapping("/listaPorDNI/{dni}")
    public List<Alumno> listaPorDNI(@PathVariable String dni){
    	return service.listaPorDNI(dni);
    }
    
    @GetMapping("/listaPorDniYPais/{dni}/{nombrePais}")
    public List<Alumno> listaPorDniYPais(
            @PathVariable String dni,
            @PathVariable String nombrePais){
        return service.listaPorDniYPais(dni, nombrePais);
    }
    
    @GetMapping("/listaPorDniYPaisParam")
    public List<Alumno> listaPorDniYPaisParam(
            @RequestParam String dni,
            @RequestParam String nombrePais) {
        return service.listaPorDniYPais(dni, nombrePais);
    }
    
    
}//fin de la clase
