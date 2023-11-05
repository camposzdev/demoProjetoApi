package com.example.demoProjetoApi.controller;

import com.example.demoProjetoApi.model.Produto;
import com.example.demoProjetoApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository prodRepo;


    @GetMapping
    public List<Produto> listarProdutos() {
        return prodRepo.findAll();
    }

    @GetMapping("/produto{cod}")
    public Optional<Produto> BuscarPorCodigo(
            @PathVariable(value="cod")int cod){
        return prodRepo.findById(cod);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Produto> buscarProdutosPorDescricao(@PathVariable String descricao) {
        return prodRepo.buscarProdutosPorDescricao(descricao);
    }

    @GetMapping("/preco-menor/{preco}")
    public List<Produto> buscarProdutosPorPrecoMenorQue(@PathVariable double preco) {
        return prodRepo.buscarProdutosPorPrecoMenorQue(preco);
    }

    @GetMapping("/marca/{marca}")
    public List<Produto> buscarProdutosPorMarca(@PathVariable String marca) {
        return prodRepo.buscarProdutosPorMarca(marca);
    }

    @GetMapping("/marca-preco")
    public List<Produto> buscarProdutosPorMarcaEPrecoMenorQue(
            @RequestParam(value = "marca", required = false) String marca,
            @RequestParam(value = "preco", required = false) Double preco) {
        return prodRepo.buscarProdutosPorMarcaEPrecoMenorQue(marca, preco);
    }

    @PutMapping("/{codigo}")
    public Produto atualizarProduto(@PathVariable Long codigo, @RequestBody Produto produto) {
        return prodRepo.atualizarProduto(codigo, produto);
    }

    @DeleteMapping("/{codigo}")
    public void removerProduto(@PathVariable Long codigo) {
        prodRepo.removerProduto(codigo);
    }

    @PutMapping("/atualizarProduto")
    public void atualizarProduto(@RequestBody Produto produto)
    {
        prodRepo.save(produto);
    }

}
