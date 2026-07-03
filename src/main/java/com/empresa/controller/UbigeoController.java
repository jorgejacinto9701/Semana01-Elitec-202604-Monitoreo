package com.empresa.controller;

import com.empresa.entity.Modalidad;
import com.empresa.entity.Ubigeo;
import com.empresa.service.UbigeoService;
import com.empresa.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url/ubigeo")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UbigeoController {

    @Autowired
    private UbigeoService service;

    @GetMapping("/listaDepartamento")
    public List<String> lstDepartamento(){
        return service.listaDepartamento();
    }
    @GetMapping("/listaProvincia/{dep}")
    public List<String> lstProvincia(@PathVariable String dep){
        return service.listaProvincia(dep);
    }
    @GetMapping("/listaDistrito/{dep}/{pro}")
    public List<Ubigeo> lstDistrito(@PathVariable String dep,@PathVariable String pro){
        return service.listaDistrito(dep, pro);
    }
}
