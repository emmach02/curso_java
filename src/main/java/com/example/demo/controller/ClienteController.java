package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor

public class ClienteController {
    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<Cliente> getClienteByNombre(@RequestParam String name){
        try {
            Cliente cliente = clienteService.getClientesByName(name);
            return ResponseEntity.ok(cliente);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().header("ERROR_MSG", e.getMessage()).build();
        }
    }
}
