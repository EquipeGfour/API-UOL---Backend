package com.uol.crud.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.crud.entidade.Categoria;

public interface CategoriaRepositorio extends MongoRepository<Categoria, String> {

}
