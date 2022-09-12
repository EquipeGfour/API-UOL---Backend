package com.uol.cross_selling.entidade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Categoria {
	
	@Id
	private String id;
	private String nome;
	private List<Pacote> pacotes =  new ArrayList<>();

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
	
	public List<Pacote> getPacotes() {
		return pacotes;
	}
	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
}
