package com.uol.produto.controle;

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
import com.uol.produto.entidade.Produto;
import com.uol.produto.modelo.ProdutoAtualizador;
import com.uol.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/produto")
public class ProdutoControle {
	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	private ProdutoAtualizador atualizador = new ProdutoAtualizador();
	
	@GetMapping("/buscar")
	public List<Produto> buscarProdutos() {
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Produto obterProdutoID(@PathVariable String id) {
		return repositorio.findById(id).get();
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarProduto(@RequestBody @Valid Produto produto) {
		Produto produtoCriado = repositorio.save(produto);
		return "id do produto: " + produtoCriado.getId();
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizarProduto(@RequestBody Produto atualizacao, @PathVariable String id ) {
		Produto selecionado = repositorio.findById(id).orElse(null);	
		if(selecionado != null){
			atualizador.atualizarProduto(selecionado, atualizacao);
			repositorio.save(selecionado);
			return "Produto Atualizado com Sucesso";
		}
		return "Produto de id " + id + " não existe.";
	}
	
	@DeleteMapping("/excluir/{id}")
	public String excluirProduto(@PathVariable String id) {
		Produto selecionado = repositorio.findById(id).orElse(null);
		if(selecionado != null) {
			repositorio.delete(selecionado);
			return "Produto excluido.";
		}
		return "Produto de id " + id + " não existe.";
	}
	
	
}
