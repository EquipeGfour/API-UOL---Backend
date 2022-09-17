package com.uol.cross_selling.modelo;

public class RespostaGet extends Resposta {

	private Object dados;
	
	public RespostaGet(String mensagem, String id,Object dados) {
		super(mensagem, id);
		this.dados = dados;
		
	}

	public Object getDados() {
		return dados;
	}

	public void setDados(Object dados) {
		this.dados = dados;
	}

	
}
