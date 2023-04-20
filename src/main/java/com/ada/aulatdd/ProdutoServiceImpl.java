package com.ada.aulatdd;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> listarProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoAtual = produtoRepository.findById(id).orElse(null);
        if (produtoAtual != null) {
            produtoAtual.setNome(produto.getNome());
            produtoAtual.setDescricao(produto.getDescricao());
            produtoAtual.setPreco(produto.getPreco());
            return produtoRepository.save(produtoAtual);
        }
        return null;
    }

    @Override
    public boolean excluirProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            produtoRepository.delete(produto);
            return true;
        }
        return false;
    }
}
