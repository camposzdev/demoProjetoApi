package com.example.demoProjetoApi.repository;

import com.example.demoProjetoApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("select a from Produto a where a.descr like %?1%")
    List<Produto> buscarProdutosPorDescricao(String descricao);

    @Query("select a from Produto a where a.preco <?1")
    List<Produto> buscarProdutosPorPrecoMenorQue(double preco);

    List<Produto> buscarProdutosPorMarca(String marca);


    List<Produto> buscarProdutosPorMarcaEPrecoMenorQue(String marca, Double preco);
}
