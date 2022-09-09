package com.uol.crud.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.crud.entidade.Pacote;

public interface PacoteRepositorio extends MongoRepository<Pacote, String>{

	
}
