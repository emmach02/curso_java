package com.example.demo.controller;

import com.example.demo.domain.Mueble;
import com.example.demo.dto.MuebleDTO;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.mapper.MuebleMapper;
import com.example.demo.service.MuebleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<MuebleDTO> getById(@PathVariable Long id){
        try {
            MuebleDTO mueble = muebleService.getMuebleById(id);
            return ResponseEntity.ok(mueble);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().header("ERROR_MSG", e.getMessage()).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<MuebleDTO> post(@RequestBody MuebleDTO muebleDTO){
        try {
            MuebleDTO muebleDTO1 = muebleService.create(muebleDTO);
            return ResponseEntity.ok(muebleDTO1);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().header("ERROR_MSG", e.getMessage()).build();
        } catch (BadRequestException e){
            return ResponseEntity.badRequest().header("ERROR_MSG", e.getMessage()).build();
        }
    }
}
