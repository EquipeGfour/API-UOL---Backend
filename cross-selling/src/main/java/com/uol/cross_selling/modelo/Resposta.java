package com.uol.cross_selling.modelo;

public class Resposta {

	private String mensagem;
	private String id;
	
	public Resposta(String mensagem, String id) {
		super();
		this.mensagem = mensagem;
		this.id = id;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
}
