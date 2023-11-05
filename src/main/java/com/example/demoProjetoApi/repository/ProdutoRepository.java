package com.example.demoProjetoApi.repository;

import com.example.demoProjetoApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> buscarProdutosPorDescricao(String descricao);

    List<Produto> buscarProdutosPorPrecoMenorQue(double preco);

    List<Produto> buscarProdutosPorMarca(String marca);

    void removerProduto(Long codigo);

    Produto atualizarProduto(Long codigo, Produto produto);
}
