package com.uol.cross_selling.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.cross_selling.entidade.Categoria;

public interface CategoriaRepositorio extends MongoRepository<Categoria, String>{

}
