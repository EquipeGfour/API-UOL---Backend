package com.uol.crud.controle;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Pacote;
import com.uol.crud.entidade.Produto;
import com.uol.crud.modelo.PacoteAtualizador;
import com.uol.crud.modelo.RespostaDelete;
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.modelo.RespostaPost;
import com.uol.crud.modelo.RespostaPut;
import com.uol.crud.repositorio.PacoteRepositorio;
import com.uol.crud.repositorio.ProdutoRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/pacote")
public class PacoteControle {

	@Autowired
	private PacoteRepositorio repositorio;
	
	@Autowired
	private ProdutoRepositorio repositorioProduto;
	
	private PacoteAtualizador atualizador = new PacoteAtualizador();
	
	@GetMapping("/buscar")
	public List<Pacote> buscarPacotes(){
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public RespostaGet buscarPacoteId (@PathVariable String id){
		Pacote selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Pacote encontrado"; 
		if(selecionado == null) {
			mensagem = "Pacote não encontrado";
		}
		RespostaGet resposta = new RespostaGet(id, mensagem, selecionado);
		return resposta;
	}
	
	@PostMapping("/cadastrar")
	public RespostaPost cadastrarPacote (@RequestBody @Valid Pacote pacote) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		for (Produto p:pacote.getProdutos()) {
			Produto selecionado = repositorioProduto.findById(p.getId()).orElse(null);
			if(selecionado != null) {
				produtos.add(selecionado);
			}
		}
		
		pacote.setProdutos(produtos);
		Pacote pacoteCriado = repositorio.save(pacote);	
		RespostaPost resposta = new RespostaPost(pacoteCriado.getId(), "Pacote Criado com Sucesso");
		return resposta;
	}
	
	@PutMapping("/atualizar/{id}")
	public RespostaPut atualizarPacote(@RequestBody Pacote atualizacao, @PathVariable String id) {
		Pacote selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Pacote não encontrado";
		if(selecionado != null) {
			mensagem = "Pacote Atualizado com Sucesso";
			atualizador.atualizarPacote(selecionado, atualizacao);
			repositorio.save(selecionado);
		}
		RespostaPut resposta = new RespostaPut(id, mensagem);
		return resposta;
	}
	
	
	@DeleteMapping("/excluir/{id}")
	public RespostaDelete excluirPacote(@PathVariable String id) {
		Pacote selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Pacote não encontrado";
		if(selecionado != null) {
			mensagem = "Pacote excluido.";
			repositorio.delete(selecionado);
		}
		RespostaDelete resposta = new RespostaDelete(id, mensagem);
		return resposta;
	}

}
