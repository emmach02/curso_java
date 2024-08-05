package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fabricante")

public class Fabricante {

    @Id
    @Column(name = "fabid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fabricanteId;

    @Column(name ="nombre")
    private String nombre;
}
