package com.empresa.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "modalidad")
public class Modalidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodalidad")
    private int idModalidad;
    private String nombre;
    private int numhombres;
    private int nummujeres;
    private int edadmaxima;
    private int edadminima;
    private String sede;
    private int estado;
    private LocalDateTime fecharegistro;
    private LocalDateTime fechaactualizacion;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddeporte")
    private Deporte deporte;

}
