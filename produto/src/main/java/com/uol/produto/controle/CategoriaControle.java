package com.uol.produto.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.produto.entidade.Categoria;
import com.uol.produto.repositorio.CategoriaRepositorio;

@RestController
@RequestMapping ("/categoria")
public class CategoriaControle {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	@GetMapping("/buscar")
	public List<Categoria> buscarCategoria(){
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Categoria buscarCategoriaIID(@PathVariable String id) {
		return repositorio.findById(id).get();
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarCategoria(@RequestBody @Valid Categoria categoria) {
		Categoria categoriaCriada = repositorio.save(categoria);
		return "id do categoria: " + categoriaCriada.getId();
		
	}

}
