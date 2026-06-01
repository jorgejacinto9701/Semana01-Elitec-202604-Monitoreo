package com.empresa.controller;

import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.entity.Proveedor;
import com.empresa.service.ProveedorService;
import com.empresa.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listaTodosProveedor(){
        List<Proveedor> lista = proveedorService.listaTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping()
    public ResponseEntity<?> registro(@RequestBody Proveedor obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdProveedor(0);
        obj.setFechaRegistro(LocalDateTime.now());
        obj.setFechaActualizacion(LocalDateTime.now());
        obj.setEstado(1);
        Proveedor objSalida = proveedorService.insertaProveedor(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso");
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/consultaDinamica")
    public ResponseEntity<List<Proveedor>> consulta(
            @RequestParam(name = "nombre", required = true , defaultValue = "") String vnombre,
            @RequestParam(name = "dni", required = false , defaultValue = "-1") String vdni,
            @RequestParam(name = "pais", required = false , defaultValue = "-1") int vpais,
            @RequestParam(name = "tipo", required = false , defaultValue = "-1") int vtipo,
            @RequestParam(name = "estado", required = false , defaultValue = "-1") int vestado){
        List<Proveedor> lista = proveedorService.consultaDinamica(
                        "%"+vnombre.toLowerCase()+"%", vdni, vpais,vtipo, vestado);
        return ResponseEntity.ok(lista);
    }

}
