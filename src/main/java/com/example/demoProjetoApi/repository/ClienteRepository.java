package com.example.demoProjetoApi.repository;

import com.example.demoProjetoApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByParteNome(String parteNome);

    List<Cliente> buscarClientesPorEmail(String email);

    void removerCliente(int cod);
}
