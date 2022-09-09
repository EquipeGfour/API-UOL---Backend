package com.uol.crud.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.crud.entidade.Produto;

public interface ProdutoRepositorio extends MongoRepository<Produto, String>{

}
