package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MuebleDTO {

    private Long muebleId;

    private String nombre;

    private Long cantDisponible;

    private Long fabricanteId;
}
