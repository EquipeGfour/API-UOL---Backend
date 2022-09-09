package com.uol.crud.controle;

import java.util.ArrayList;
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

import com.uol.crud.entidade.Pacote;
import com.uol.crud.entidade.Produto;
import com.uol.crud.modelo.PacoteAtualizador;
import com.uol.crud.repositorio.PacoteRepositorio;
import com.uol.crud.repositorio.ProdutoRepositorio;

@RestController
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
	public Pacote buscarPacoteId (@PathVariable String id){
		return repositorio.findById(id).orElse(null);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarPacote (@RequestBody @Valid Pacote pacote) {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		for (Produto p:pacote.getProdutos()) {
			Produto selecionado = repositorioProduto.findById(p.getId()).orElse(null);
			if(selecionado != null) {
				produtos.add(selecionado);
			}
		}
		pacote.setProdutos(produtos);
		Pacote pacoteCriado = repositorio.save(pacote);	
		return pacoteCriado.getId();
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizarPacote(@RequestBody Pacote atualizacao, @PathVariable String id) {
		Pacote selecionado = repositorio.findById(id).orElse(null);
		if(selecionado != null) {
			atualizador.atualizarPacote(selecionado, atualizacao);
			repositorio.save(selecionado);
			return "Pacote excluido.";
		}
		return "Pacote de id " + id + " não existe.";
	}
	
	
	@DeleteMapping("/excluir/{id}")
	public String excluirPacote(@PathVariable String id) {
		Pacote selecionado = repositorio.findById(id).orElse(null);
		if(selecionado != null) {
			repositorio.delete(selecionado);
			return "Pacote excluido.";
		}
		return "Pacote de id " + id + " não existe.";
	}

}
