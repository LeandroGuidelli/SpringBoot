package br.com.aweb.sistema_vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.entity.Produto;
import br.com.aweb.sistema_vendas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
     @Autowired
    ProdutoRepository produtoRepository;

    // Método para criar produto
    @Transactional
    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
