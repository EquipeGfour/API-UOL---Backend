package com.uol.crud.modelo;

public class RespostaGet extends Resposta {

	private Object dados;
	
	public RespostaGet(String id, String mensagem, Object dados) {
		super(id, mensagem);
		this.dados = dados;
	}

	public Object getDados() {
		return dados;
	}

	public void setDados(Object dados) {
		this.dados = dados;
	}

}
