package com.empresa.controller;

import com.empresa.entity.Docente;
import com.empresa.service.DocenteService;
import com.empresa.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/url/docente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class DocenteController {

    @Autowired
    private DocenteService service;

    @PostMapping()
    public ResponseEntity<?> registro(@RequestBody Docente obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdDocente(0);
        Docente objSalida = service.insertaDocente(obj);
        salida.put("mensaje", "Docente '"+  obj.getNombres()+ "' Registrado de ID : " + obj.getIdDocente());
        return ResponseEntity.ok(salida);
    }
}
