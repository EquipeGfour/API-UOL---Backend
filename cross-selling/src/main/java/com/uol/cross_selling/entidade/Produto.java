package com.uol.cross_selling.entidade;

import org.springframework.data.annotation.Id;
import java.util.List;

public class Produto {
	
	@Id
	private String id;
	private String nome;
	private Double preco;
	private String descricao;
	private List<Categoria> categorias;
	private List<Categoria> sugestao;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Categoria> getSugestao() {
		return sugestao;
	}
	public void setSugestao(List<Categoria> sugestao) {
		this.sugestao = sugestao;
	}
	

}
