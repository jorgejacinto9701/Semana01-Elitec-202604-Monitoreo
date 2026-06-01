package com.empresa.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.empresa.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@RestController
@RequestMapping("/url/modalidad")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ModalidadController {

    @Autowired
    private ModalidadService modalidadService;

    @GetMapping
    public ResponseEntity<List<Modalidad>> listaTodos(){
        List<Modalidad> lista = modalidadService.listaTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/porNombre/{filtro}")
    public ResponseEntity<List<Modalidad>> listaPorNombre(@PathVariable String filtro){
        List<Modalidad> lista = modalidadService.listaPorNombre(filtro);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/porSede/{sede}")
    public ResponseEntity<List<Modalidad>> listaPorSede(@PathVariable String sede){
        List<Modalidad> lista = modalidadService.listaPorSede(sede);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/porDeporte/{desde}-{hasta}")
    public ResponseEntity<List<Modalidad>> porDeporte(@PathVariable int desde, @PathVariable int hasta){
        List<Modalidad> lista = modalidadService.listaPorRangoDeporte(desde, hasta);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/general")
    public ResponseEntity<List<Modalidad>> consultaGenetal(@RequestParam String sede, @RequestParam int estado, @RequestParam String nombre){
        List<Modalidad> lista = modalidadService.listaGeneral(sede, estado, nombre);
        return ResponseEntity.ok(lista);
    }


    @PostMapping()
    public ResponseEntity<?> registro(@RequestBody Modalidad obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdModalidad(0);
        obj.setFechaactualizacion(LocalDateTime.now());
        obj.setFecharegistro(LocalDateTime.now());
        obj.setEstado(1);
        Modalidad objSalida = modalidadService.insertaModalidad(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso");
        return ResponseEntity.ok(salida);
    }

    @PutMapping
    public ResponseEntity<?> actualiza(@RequestBody Modalidad obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setFechaactualizacion(LocalDateTime.now());
        Modalidad objSalida = modalidadService.insertaModalidad(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso");
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> elimina(@PathVariable int id){
        HashMap<String, Object> salida = new HashMap<>();
        modalidadService.eliminaModadlidad(id);
        salida.put("mensaje", "Eliminación exitosa");
        return ResponseEntity.ok(salida);
    }


}
