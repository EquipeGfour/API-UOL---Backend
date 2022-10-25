package com.uol.crud.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.repositorio.OfertaRepositorio;

@RestController
@RequestMapping("/oferta")
public class OfertaControle {
	
	@Autowired
	private OfertaRepositorio repositorio;
	
	//@GetMapping("/buscar")
	
	//@GetMapping("/busca/{id}")
	
	//@PostMapping("/cadastrar")
	
	//@PutMapping("/atualizar/{id}")
	
	//@DeleteMapping("/excluir/{id}")
	
	
}
