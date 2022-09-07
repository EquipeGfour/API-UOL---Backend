package com.uol.produto.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uol.produto.entidade.Produto;
import com.uol.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/produto")
public class ProdutoControle {

	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	
	
	@PostMapping("/cadastrar")
	public void cadastrarProduto (@RequestBody Produto produto) {
		repositorio.save(produto);
	}
	
	@GetMapping("/buscar")
	public List<Produto> buscarprodutos() {
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public Produto ObterProdutoID(@PathVariable String id) {
		return repositorio.findById(id).get();
	}
	
	
}
