package com.uol.crud.modelo;

import java.util.List;

import com.uol.crud.entidade.Categoria;
import com.uol.crud.entidade.Produto;

public class RequisicaoProdutoCategoria {
	private Produto produto;
	private List<Categoria> categorias;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
