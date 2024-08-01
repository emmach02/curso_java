package com.example.demo.service;

import com.example.demo.domain.Cliente;
import com.example.demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    public static List<Cliente> listaClientes;
    static {
        listaClientes = new ArrayList<>();
        listaClientes.add(
                new Cliente(1L, "Emmanuel")
        );
        listaClientes.add(
                new Cliente(2L, "Pedroxx_x")
        );
        listaClientes.add(
                new Cliente(3L, "Juan")
        );
    }

    public Cliente getClientesByName(String nombre) throws NotFoundException{
        Optional<Cliente> cliente = listaClientes.stream().filter( x -> x.getNombre().equals(nombre)).findFirst();

        if (cliente.isEmpty()){
            throw new NotFoundException("No se encontró cliente");
        } else {
            return cliente.get();
        }
    }
}
