package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Docente;
import com.empresa.service.DocenteService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/docente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class DocenteController {
	/*el endpoint (@GetMapping) para recibir el parámetro
	 * (usualmente mediante @PathVariable o @RequestParam) y asi retorna la lista*/

	@Autowired
    private DocenteService service;

 // listar todos

    @GetMapping("/listaTodos")
    public List<Docente> listaTodos() {
        return service.listaTodos();
    }

 // Alistar pr nombre
    @GetMapping("/listaPorNombre/{filtro}")
    public List<Docente> listaPorNombre(@PathVariable String filtro) {
        return service.listaPorNombre(filtro);
    }

  // Endpoint para buscar por el ID de Ubigeo
    @GetMapping("/listaPorUbigeo/{idUbigeo}")
    public List<Docente> listaPorUbigeo(@PathVariable("idUbigeo") int idUbigeo) {
        return service.listaDocentePorUbigeo(idUbigeo);
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<Docente>> consultaPorNombreYUbigeo(
            @RequestParam(name = "nombre", defaultValue = "") String nombre,
            @RequestParam(name = "ubigeo") Integer ubigeo) {

        // CORRECCIÓN: Cambiado de List<List<Docente>> a List<Docente>
        List<Docente> lista = service.listaDocentesPorNombreYUbigeo(nombre, ubigeo);
        return ResponseEntity.ok(lista);
    }

}// FIN DE PUBLIC CLASS
