package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
