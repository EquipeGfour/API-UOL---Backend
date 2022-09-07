package com.uol.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.produto.entidade.Pacote;
import com.uol.produto.repositorio.PacoteRepositorio;

@RestController
@RequestMapping("/pacote")
public class PacoteControle {

	@Autowired
	private PacoteRepositorio repositorio;
	
	@GetMapping("/buscar")
	public List<Pacote> buscarPacotes(){
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Pacote buscarPacoteId (@PathVariable String id){
		return repositorio.findById(id).orElse(null);
	}
	
	


}
