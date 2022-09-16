package com.uol.crud.controle;

import java.util.List;

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
import com.uol.crud.modelo.RespostaDelete;
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.modelo.RespostaPost;
import com.uol.crud.modelo.RespostaPut;
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
	public RespostaGet buscarCategoriaIID(@PathVariable String id) {
		Categoria selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Categoria encontrada.";
		if(selecionado == null) {
			mensagem = "Categoria não encontrada.";
		}
		RespostaGet resposta = new RespostaGet(id, mensagem, selecionado);
		return resposta;		
	}
	
	@PostMapping("/cadastrar")
	public RespostaPost cadastrarCategoria(@RequestBody Categoria categoria) {
		Categoria categoriaCriada = repositorio.save(categoria);
		RespostaPost resposta = new RespostaPost(categoriaCriada.getId(), "Categoria criada com sucesso.");
		return resposta;
		
	}
	
	@PutMapping("/atualizar/{id}")
	public RespostaPut atualizarCategoria(@RequestBody Categoria atualizarDados, @PathVariable String id) {
		Categoria selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Categoria não encontrada.";
		if(selecionado != null) {
			atualizador.atualizarCategoria(selecionado, atualizarDados);
			repositorio.save(selecionado);
			mensagem = "Categoria Atualizada.";
		}
		RespostaPut resposta = new RespostaPut(id, mensagem);
		return resposta;
	}
	
	@DeleteMapping("/excluir/{id}")
	public RespostaDelete excluirCategoria(@PathVariable String id) {
		Categoria selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Categoria não encontrada.";
		if(selecionado != null ) {
			repositorio.delete(selecionado);
			mensagem = "Categoris Excluida.";
			
		}
		RespostaDelete resposta = new RespostaDelete(id, mensagem);
		return resposta;
	}
	
	

}
