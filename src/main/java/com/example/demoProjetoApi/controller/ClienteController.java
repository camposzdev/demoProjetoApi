package com.example.demoProjetoApi.controller;

import com.example.demoProjetoApi.model.Cliente;
import com.example.demoProjetoApi.model.Produto;
import com.example.demoProjetoApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nome{partenome}")
    public List<Cliente> buscarPorParteNome(@PathVariable("partenome")String parteNome){
        return cliRepo.findByParteNome(parteNome);
    }

    @GetMapping("/email/{email}")
    public List<Cliente> buscarClientesPorEmail(@PathVariable String email) {
        return cliRepo.buscarClientesPorEmail(email);
    }

    @DeleteMapping("/{cod}")
    public void removerCliente(@PathVariable int cod) {
        cliRepo.removerCliente(cod);
    }

    @PutMapping("/atualizarCliente")
    public void atualizarCliente(@RequestBody Cliente cliente)
    {
        cliRepo.save(cliente);
    }
}

