package com.example.demoProjetoApi.repository;

import com.example.demoProjetoApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select a from Cliente a where a.nome like %?1%")
    List<Cliente> findByParteNome(String parteNome);

    @Query("select a from Cliente a where a.email like %?1%")
    List<Cliente> buscarParteEmail(String email);

    List<Cliente> buscarClientesPorEmail(String email);






}
