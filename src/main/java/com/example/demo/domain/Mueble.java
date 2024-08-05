package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mueble")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Mueble {

    @Id
    @Column(name ="muebleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long muebleId;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="cantdisponible")
    private Long cantDisponible;

    @ManyToOne
    @JoinColumn(name = "fabricante")
    private Fabricante fabricante;

}
