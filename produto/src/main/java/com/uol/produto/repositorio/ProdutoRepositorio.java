package com.uol.produto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.produto.entidade.Produto;

public interface ProdutoRepositorio extends MongoRepository<Produto, String>{

}
