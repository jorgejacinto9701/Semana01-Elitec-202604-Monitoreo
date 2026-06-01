package com.empresa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.dto.UsuarioLoginDto;
import com.empresa.security.JwtProvider;
import com.empresa.security.UsuarioPrincipal;
import com.empresa.util.AppSettings;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/url/auth")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;
    
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDto loginUsuario){
    	log.info(">>> login >>> " + loginUsuario.getLogin());
    	log.info(">>> login >>> " + loginUsuario.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getLogin(), loginUsuario.getPassword()));
        
        log.info(">>> authentication >>> " + authentication);
        log.info(">>> Inicio de Generacion de Token ");
        //Generacion del Token
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        log.info(">>> token >>> " + token);
        
        //Validaciones en la base de datos
        UsuarioPrincipal usuario = (UsuarioPrincipal)authentication.getPrincipal();
        log.info(">>> usuario >>> " + usuario.toString());
        

        Map<String, Object> response = new HashMap<>();
        response.put("bearer", "Bearer");
        response.put("token", token);
        
        return ResponseEntity.ok(response);
    }
}
