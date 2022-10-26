package com.uol.crud.entidade;

import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class Produto {

	@Id
	private String id;
	@NotNull(message = "O Nome não pode ser um Valor Nulo.")
	private String nome;
	@NotNull(message = "O Preço não pode ser um Valor Nulo.")
	private Double preco;
	@NotNull(message = "A Descrição não pode ser um Valor Nulo.")
	private String descricao;
	private Double desconto;
	private List<Categoria> categorias;
	private List<Produto> sugestao;


	public String getId() {
		return id;
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
	
	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Produto> getSugestao() {
		return sugestao;
	}
	public void setSugestao(List<Produto> sugestao) {
		this.sugestao = sugestao;
	}
	
}
