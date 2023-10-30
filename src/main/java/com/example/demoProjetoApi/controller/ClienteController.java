package com.example.demoProjetoApi.controller;

import com.example.demoProjetoApi.model.Cliente;
import com.example.demoProjetoApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository cliRepo;

    @GetMapping("/todos")
    public List<Cliente> BuscarTodosClientes(){
        return cliRepo.findAll();
    }

    @GetMapping("/clientes{cod}")
    public Optional<Cliente> BuscarPorCodigo(
            @PathVariable(value="cod")int cod){
        return cliRepo.findById(cod);
    }

}
