package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mueble")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Mueble {

    @Id
    @Column(name ="muebleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long muebleId;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="cantdisponible")
    private Long cantDisponible;

}
