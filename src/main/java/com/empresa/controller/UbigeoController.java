package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Ubigeo;
import com.empresa.service.UbigeoService;
import com.empresa.util.AppSettings;

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
