package com.uol.cross_selling.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.cross_selling.entidade.Categoria;
import com.uol.cross_selling.entidade.Pacote;
import com.uol.cross_selling.entidade.Produto;
import com.uol.cross_selling.repositorio.CategoriaRepositorio;
import com.uol.cross_selling.repositorio.PacoteRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/compra")
public class CompraControle {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired
	private PacoteRepositorio pacoteRepositorio;
	
	@GetMapping("/compre-junto/{id}")
	public List<Pacote> compreJunto(@PathVariable String id){
		List<Pacote> pacotes = pacoteRepositorio.findAllPacoteByProdutosId(id);
		return pacotes;
	}
	
	@GetMapping("/produtos-relacionados/{id}")
	public List<Produto> produtosRelacionados(@PathVariable String id){
		Categoria categoria = categoriaRepositorio.findById(id).orElse(null);
		return categoria.getProdutos();
	}
	
}