package com.uol.produto.modelo;

public class VerificarNulo {

	public boolean VerificarString(String dado) {
		boolean nulo = true;
		if (!(dado == null)) {
			if (dado.isBlank()) {
				nulo = false;
			}
		}
		return nulo;
	}
	
	public boolean VerificarDooble(Double dados) {
		boolean nulo = true;
		if(!(dados == null)) {
			if(dados.isNaN()) {
				nulo = false;
			}
		}
		return nulo;
	}
	
	
}
