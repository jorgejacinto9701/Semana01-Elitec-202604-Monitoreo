package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Libro;
import com.empresa.service.LibroService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/libro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroController {

    @Autowired
    private LibroService service;


    @GetMapping("/porTitulo/{filtro}")
    public ResponseEntity<List<Libro>> listaPorTitulo(@PathVariable String filtro){
        List<Libro> lista = service.listaPorTitulo("%"+filtro+"%");
        return ResponseEntity.ok(lista);
    }

    @PostMapping()
    public ResponseEntity<?> registro(@RequestBody Libro obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdLibro(0);
        Libro objSalida = service.insertaLibro(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso");
        return ResponseEntity.ok(salida);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> elimina(@PathVariable int id){
        HashMap<String, Object> salida = new HashMap<>();
        service.eliminaLibro(id);
        salida.put("mensaje", "Eliminación exitosa");
        return ResponseEntity.ok(salida);
    }


}
