package com.example.demo.controller;

import com.example.demo.domain.Mueble;
import com.example.demo.dto.MuebleDTO;
import com.example.demo.mapper.MuebleMapper;
import com.example.demo.service.MuebleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/muebles")
@AllArgsConstructor

public class MuebleController {

    @Autowired
    private final MuebleService muebleService;

    @GetMapping("")
    public ResponseEntity<List<MuebleDTO>> getAll(){
        List<MuebleDTO> muebles = muebleService.getAllMuebles();
        return ResponseEntity.ok(muebles);
    }
}
