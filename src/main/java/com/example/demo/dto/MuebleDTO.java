package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class MuebleDTO {

    private Long muebleId;

    private String nombre;

    private Long cantDisponible;
}
