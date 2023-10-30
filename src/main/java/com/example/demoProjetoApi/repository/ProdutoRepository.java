package com.example.demoProjetoApi.repository;

import com.example.demoProjetoApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
