package com.uol.produto.entidade;

import org.springframework.data.annotation.Id;

public class Produto {

	@Id
	private String id;
	private String nome;
	private Double preco;
	private String descricao;
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
}
