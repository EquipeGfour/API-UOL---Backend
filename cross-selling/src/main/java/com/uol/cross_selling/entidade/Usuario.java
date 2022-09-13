package com.uol.cross_selling.entidade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;



public class Usuario {
	
	@Id
	private String id;
	private String nome;
	private Long cpf;
	private Long telefone;
	private String email;
	private String senha;
	private List<Pacote> pacotes = new ArrayList<>();
	private List<Categoria> interesses = new ArrayList<>();
	
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
	
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Pacote> getPacotes() {
		return pacotes;
	}
	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	public List<Categoria> getInteresses(){
		return interesses;
	}
	
	public void setInteresses(List<Categoria> interesses) {
		this.interesses = interesses;
	}
	
}
