package com.example.demo.mapper;

import com.example.demo.domain.Mueble;
import com.example.demo.dto.MuebleDTO;

public class MuebleMapper {

    public static MuebleDTO toDTO(Mueble mueble) {
        return MuebleDTO.builder()
                .muebleId(mueble.getMuebleId())
                .nombre(mueble.getNombre())
                .cantDisponible(mueble.getCantDisponible())
                .build();
    }
}
