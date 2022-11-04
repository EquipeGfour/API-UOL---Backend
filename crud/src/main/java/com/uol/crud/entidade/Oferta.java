package com.uol.crud.entidade;

import java.util.List;

public class Oferta {
	private String id;
	private String nome;
	private String descricao;
	private String dataInicio;
	private String dataExpiracao;
	private Double desconto;
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
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	
	public List<Pacote> getPacotes() {
		return pacotes;
	}
	
	public void setPacotes(List <Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
}
