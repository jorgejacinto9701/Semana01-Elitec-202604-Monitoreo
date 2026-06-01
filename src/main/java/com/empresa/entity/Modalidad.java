package com.empresa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
