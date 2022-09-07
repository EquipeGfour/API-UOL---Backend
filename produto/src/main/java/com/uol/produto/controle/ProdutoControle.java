package com.uol.produto.controle;

import org.springframework.beans.factory.annotation.Autowired;
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
}
