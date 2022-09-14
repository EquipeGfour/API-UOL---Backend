package com.uol.cross_selling.modelo;

public class RespostaLogin extends Resposta {
	
	public Object dadosLogin;
	
	public RespostaLogin(String mensagem, String id, Object dadosLogin) {
		super(mensagem, id);
		this.dadosLogin = dadosLogin;
	}

	public Object getDadosLogin() {
		return dadosLogin;
	}

	public void setDadosLogin(Object dadosLogin) {
		this.dadosLogin = dadosLogin;
	}
	
	

}
