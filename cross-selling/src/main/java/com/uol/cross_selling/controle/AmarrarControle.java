package com.uol.cross_selling.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class AmarrarControle {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired
	private PacoteRepositorio pacoteRepositorio;
	
	@GetMapping("/amarrar/{id}")
	public List<Pacote> compreJunto(@PathVariable String id){
		List<Pacote> pacotes = pacoteRepositorio.findAllPacoteByProdutosId(id);
		List<Pacote> novaLista = new ArrayList<Pacote>();
		Random random = new Random();
		if(pacotes.size() > 3) {
			for(int i = 0; i < 3; i++) {
				int valor = random.nextInt(pacotes.size()-1);
				Pacote p = pacotes.get(valor);
				novaLista.add(p);
				pacotes.remove(valor);
			}
			return novaLista;
		}
		return pacotes;
	}
	
	@GetMapping("/produtos-relacionados/{id}")
	public List<Produto> produtosRelacionados(@PathVariable String id){
		Categoria categoria = categoriaRepositorio.findById(id).orElse(null);
		return categoria.getProdutos();
	}
	
	
	@GetMapping("/selecionar-sugestoes/{categorias}")
	public List<Produto> selecionarSugestoes (@PathVariable List<Categoria> categorias) {
		List<Produto> produtosCategoria = new ArrayList<Produto>();
		for(Categoria c: categorias) {
			Categoria categoriaSelecionada = categoriaRepositorio.findById(c.getId()).orElse(null);
			produtosCategoria.addAll(categoriaSelecionada.getProdutos());
		}return produtosCategoria;
	}
	
}