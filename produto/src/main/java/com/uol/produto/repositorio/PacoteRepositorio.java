package com.uol.produto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.produto.entidade.Pacote;

public interface PacoteRepositorio extends MongoRepository<Pacote, String>{

	
}
