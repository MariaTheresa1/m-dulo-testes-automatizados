package com.ada.aulatdd;

import java.util.List;

public interface ProdutoService {
    List<Produto> listarProdutos();
    Produto buscarProdutoPorId(Long id);
    Produto criarProduto(Produto produto);
    Produto atualizarProduto(Long id, Produto produto);
    boolean excluirProduto(Long id);
}
