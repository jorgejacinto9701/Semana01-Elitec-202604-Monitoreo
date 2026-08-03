package com.empresa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plato")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlato;

    private String nombre;
    private String categoria;
    private String descripcion;
    private String precio;
    private int tiempo;
    private LocalDate fechaIncorporacion;
    private String nivelPicante;
}