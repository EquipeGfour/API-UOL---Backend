package com.uol.cross_selling.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.cross_selling.entidade.Pacote;

public interface PacoteRepositorio extends MongoRepository<Pacote, String>{

	List<Pacote> findAllPacoteByProdutosId(String id);

}
