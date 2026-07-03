package com.empresa.controller;

import com.empresa.dto.ProveedorEstadoDTO;
import com.empresa.dto.ProveedorMesDTO;
import com.empresa.dto.ProveedorPaisDTO;
import com.empresa.dto.ProveedorTipoDTO;
import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.entity.Proveedor;
import com.empresa.service.ProveedorService;
import com.empresa.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        salida.put("mensaje", "Proveedor registrado exitosamente de ID >>>> " + objSalida.getIdProveedor());
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

    @DeleteMapping("/eliminaPorId/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> elimina(@PathVariable("id") int idProveedor) {
        Map<String, Object> salida = new HashMap<>();
        try {
            proveedorService.eliminaProveedor(idProveedor);
            salida.put("mensaje","Se elimina el Proveedor de ID ==> " + idProveedor + "." );
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "No se eliminó, ya que el registro esta relacionado.");
        }
        return ResponseEntity.ok(salida);
    }


    @PutMapping("/actualizaProveedor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualiza(@RequestBody Proveedor obj) {
        Map<String, Object> salida = new HashMap<>();
        obj.setFechaRegistro(LocalDateTime.now());
        obj.setFechaActualizacion(LocalDateTime.now());
        Proveedor objSalida = proveedorService.insertaProveedor(obj);
        salida.put("mensaje", "Proveedor actualizado exitosamente de ID >>>> " + objSalida.getIdProveedor());
        return ResponseEntity.ok(salida);
    }


    @GetMapping("/grafico/pais")
    public ResponseEntity<List<ProveedorPaisDTO>> graficoPais() {
        List<ProveedorPaisDTO> lista = proveedorService.cantidadPorPais();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/grafico/estado")
    public ResponseEntity<List<ProveedorEstadoDTO>> graficoEstado() {
        List<ProveedorEstadoDTO> lista = proveedorService.cantidadPorEstado();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/grafico/tipo")
    public ResponseEntity<List<ProveedorTipoDTO>> graficoTipo() {
        List<ProveedorTipoDTO> lista = proveedorService.cantidadPorTipo();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/grafico/mes")
    public ResponseEntity<List<ProveedorMesDTO>> graficoMes() {
        List<ProveedorMesDTO> lista = proveedorService.cantidadPorMes();
        return ResponseEntity.ok(lista);
    }
}
