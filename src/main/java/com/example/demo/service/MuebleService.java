package com.example.demo.service;

import com.example.demo.domain.Mueble;
import com.example.demo.dto.MuebleDTO;
import com.example.demo.mapper.MuebleMapper;
import com.example.demo.repository.MuebleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MuebleService {

    @Autowired
    private final MuebleRepository muebleRepository;

    public List<MuebleDTO> getAllMuebles(){
        List<Mueble> lista = muebleRepository.findAll();
        return lista.stream()
                .map(MuebleMapper::toDTO)
                .toList();
    }

}
