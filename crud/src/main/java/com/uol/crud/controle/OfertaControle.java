package com.uol.crud.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Oferta;
import com.uol.crud.repositorio.OfertaRepositorio;

@RestController
@RequestMapping("/oferta")
public class OfertaControle {
	
	@Autowired
	private OfertaRepositorio repositorio;
	
	@GetMapping("/buscar")
	public List<Oferta> buscarOfertas(){
	    return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Oferta buscarOfertaPorId(@PathVariable String id) {
	    Oferta oferta = repositorio.findById(id).orElse(null);
	    return oferta;
	}
	
	//@PostMapping("/cadastrar")
	
	//@PutMapping("/atualizar/{id}")
	
	//@DeleteMapping("/excluir/{id}")
	
	
}