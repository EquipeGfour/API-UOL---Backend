package com.uol.crud.entidade;

import java.util.List;

public class Oferta {
	private String id;
	private String nome;
	private String descricao;
	private Double preco;
	private List<Pacote> pacotes; 
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}
	
	public void setPacotes(List <Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
}
