package com.example.demo.controller;

import com.example.demo.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes/")
@AllArgsConstructor

public class ClienteController {
    @Autowired
    private final ClienteService clienteService;
}
