package com.uol.produto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.produto.entidade.Categoria;

public interface CategoriaRepositorio extends MongoRepository<Categoria, String> {

}
