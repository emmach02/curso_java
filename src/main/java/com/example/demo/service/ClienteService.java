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
        // el optional es por si cliente trae o no un objeto Cliente, porque podría traer null o vacío
        Optional<Cliente> cliente = listaClientes.stream().filter( x -> x.getNombre().equals(nombre)).findFirst();

        // verificación que sea empty, manejo de error - Si es empty lanza NotFound y si no continúa
        if (cliente.isEmpty()){
            throw new NotFoundException("No se encontró cliente");
        } else {
            // siempre devolver el objeto
            return cliente.get();
        }
    }
}
