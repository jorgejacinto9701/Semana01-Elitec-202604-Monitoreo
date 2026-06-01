package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ubigeo")
public class Ubigeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idubigeo")
    private int idUbigeo;
    private String departamento;
    private String provincia;
    private String distrito;

}
