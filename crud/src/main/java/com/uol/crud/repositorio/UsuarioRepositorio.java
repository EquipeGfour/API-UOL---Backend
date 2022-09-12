package com.uol.crud.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.crud.entidade.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

}
