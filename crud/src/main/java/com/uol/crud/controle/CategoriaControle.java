package com.uol.crud.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Categoria;
import com.uol.crud.modelo.CategoriaAtualizador;
import com.uol.crud.repositorio.CategoriaRepositorio;

@RestController
@RequestMapping ("/categoria")
public class CategoriaControle {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	private CategoriaAtualizador atualizador = new CategoriaAtualizador(); 
	
	@GetMapping("/buscar")
	public List<Categoria> buscarCategoria(){
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Categoria buscarCategoriaIID(@PathVariable String id) {
		return repositorio.findById(id).get();
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarCategoria(@RequestBody Categoria categoria) {
		Categoria categoriaCriada = repositorio.save(categoria);
		return "id do categoria: " + categoriaCriada.getId();
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizarCategoria(@RequestBody Categoria atualizarDados, @PathVariable String id) {
		Categoria selecionado = repositorio.findById(id).orElse(null);
		if(selecionado != null) {
			atualizador.atualizarCategoria(selecionado, atualizarDados);
			repositorio.save(selecionado);
			return "Categoria Atualizada.";
		}
		return "Categoria de Id " + id + " Não Existe.";
	}
	
	@DeleteMapping("/excluir/{id}")
	public String excluirCategoria(@PathVariable String id) {
		Categoria selecionado = repositorio.findById(id).orElse(null);
		if(selecionado != null ) {
			repositorio.delete(selecionado);
			return "Categoria Excluída.";
		}
		return "Categoria de Id " + id + " Não Existe.";
	}
	
	

}
