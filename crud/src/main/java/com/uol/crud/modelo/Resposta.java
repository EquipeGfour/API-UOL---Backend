package com.uol.crud.modelo;

public class Resposta {
	
	private String id;
	private String mensagem;
	
	public Resposta(String id, String mensagem) {
		super();
		this.id = id;
		this.mensagem = mensagem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	

	
	

}
