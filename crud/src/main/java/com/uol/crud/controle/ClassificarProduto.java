package com.uol.crud.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Categoria;
import com.uol.crud.modelo.RespostaPut;
import com.uol.crud.repositorio.CategoriaRepositorio;

@RestController
@RequestMapping("/categoria")
public class ClassificarProduto {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	@PutMapping("/classificar")
	public RespostaPut alocarProduto(@RequestBody Categoria categoria) {
		Categoria selecionado = repositorio.findById(categoria.getId()).orElse(null);
		String mensagem = "Categoria não encontrada";
		if(selecionado != null) {
			selecionado.getProdutos().addAll(categoria.getProdutos());
			repositorio.save(selecionado);
			mensagem = "Produtos classificados com sucesso!";
		}
		RespostaPut reposta = new RespostaPut(categoria.getId(), mensagem);
		return reposta;	
		
	}
	
}
