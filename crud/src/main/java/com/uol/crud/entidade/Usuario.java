package com.uol.crud.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Usuario {
	
	@Id
	private String id;
	@NotNull(message = "O Nome não pode ser um Valor Nulo.")
	private String nome;
	@NotNull(message = "O Cpf não pode ser um Valor Nulo.")
	private String cpf;
	@NotNull(message = "O Email não pode ser um Valor Nulo.")
	private String email;
	@NotNull(message = "A Senha não pode ser um Valor Nulo.")
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
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
