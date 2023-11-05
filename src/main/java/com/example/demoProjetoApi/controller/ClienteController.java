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
    public List<Cliente> findByParteNome(@PathVariable("partenome")String parteNome){
        return cliRepo.findByParteNome(parteNome);
    }

    @GetMapping("/email/{email}")
    public List<Cliente> buscarPorParteEmail(@PathVariable String email) {
        return cliRepo.buscarParteEmail(email);
    }

    @GetMapping("/todos/parteemail/{email}")
    public List<Cliente> buscarPorParteNome(@PathVariable("partenome")String parteNome){
        return cliRepo.findByParteNome(parteNome);
    }

    @DeleteMapping("/remover")
    public void removerCliente(Cliente cliente){cliRepo.delete(cliente);}

    @DeleteMapping("/remover/cod/{cod}")
    public void removerPorId(@PathVariable("cod") int cod) {
        cliRepo.deleteById(cod);
    }

    @PutMapping("/atualizarCliente")
    public void atualizarCliente(@RequestBody Cliente cliente)
    {
        cliRepo.save(cliente);
    }
}

