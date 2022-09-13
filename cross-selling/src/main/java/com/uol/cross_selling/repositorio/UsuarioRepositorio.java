package com.uol.cross_selling.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.cross_selling.entidade.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

}
