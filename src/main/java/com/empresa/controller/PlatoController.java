package com.empresa.controller;

import com.empresa.entity.Plato;
import com.empresa.service.PlatoService;
import com.empresa.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/url/plato")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class PlatoController {

    @Autowired
    private PlatoService service;


    @GetMapping("/porNombre/{filtro}")
    public ResponseEntity<List<Plato>> listaPorNombre(@PathVariable String filtro){
        List<Plato> lista = service.listaPorNombre("%"+filtro+"%");
        return ResponseEntity.ok(lista);
    }

    @PostMapping()
    public ResponseEntity<?> registro(@RequestBody Plato obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdPlato(0);
        Plato objSalida = service.insertaPlato(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso");
        return ResponseEntity.ok(salida);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> elimina(@PathVariable int id){
        HashMap<String, Object> salida = new HashMap<>();
        service.eliminaPlato(id);
        salida.put("mensaje", "Eliminación exitosa");
        return ResponseEntity.ok(salida);
    }


}
