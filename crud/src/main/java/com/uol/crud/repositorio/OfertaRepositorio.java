package com.uol.crud.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uol.crud.entidade.Oferta;

public interface OfertaRepositorio extends MongoRepository<Oferta, String>{
	

}
