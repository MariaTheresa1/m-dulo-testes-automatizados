package com.ada.aulatdd;

import org.hibernate.metamodel.model.domain.MapPersistentAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDTO toDto(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco()
        );
    }

    public Produto toEntity(ProdutoDTO produtoDTO) {
        return new Produto(
                produtoDTO.getId(),
                produtoDTO.getNome(),
                produtoDTO.getDescricao(),
                produtoDTO.getPreco()
        );
    }

}

