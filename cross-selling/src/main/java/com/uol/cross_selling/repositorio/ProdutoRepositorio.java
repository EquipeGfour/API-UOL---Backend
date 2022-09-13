package com.uol.cross_selling.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.cross_selling.entidade.Produto;

public interface ProdutoRepositorio extends MongoRepository<Produto, String>{

}
