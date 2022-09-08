package com.uol.produto.entidade;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Pacote {

	
	@Id
	private String id;
	@NotNull(message = "O Nome não pode ser um Valor Nulo.")
	private String nome;
	@NotNull(message = "O Preço não pode ser um Valor Nulo.")
	private Float preco;
	@NotNull(message = "A Descrição não pode ser um Valor Nulo.")	
	private String descricao;
	//@NotNull(message = "A lista de produtos não pode ser um Valor Nulo.")
	private List<Produto> produtos;
	
	
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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
	
} 
