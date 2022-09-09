package com.uol.crud.modelo;

public class VerificarNulo {

	public boolean VerificarString(String dado) {
		boolean nulo = true;
		if (!(dado == null)) {
			if (!dado.isBlank()) {
				nulo = false;
			}
		}
		return nulo;
	}
	
	public boolean VerificarDouble(Double dado) {
		boolean nulo = true;
		if(!(dado == null)) {
			if(!dado.isNaN()) {
				nulo = false;
			}
		}
		return nulo;
	}
}
