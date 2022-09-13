package com.uol.cross_selling.entidade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Categoria {
	
	@Id
	private String id;
	private String nome;
	private List<Produto> produtos =  new ArrayList<>();

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
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> pacotes) {
		this.produtos = pacotes;
	}
}
