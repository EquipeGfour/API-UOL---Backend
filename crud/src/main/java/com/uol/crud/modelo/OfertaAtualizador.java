package com.uol.crud.modelo;

import com.uol.crud.entidade.Oferta;


public class OfertaAtualizador {

	
	private VerificarNulo verificador = new VerificarNulo();
	
	public void atualizarOferta(Oferta oferta, Oferta atualizacao) {
		
		if(atualizacao != null) {

			if(!verificador.VerificarString(atualizacao.getNome())) {
				oferta.setNome(atualizacao.getNome());
			}

			if(!verificador.VerificarString(atualizacao.getDescricao())) {
				oferta.setDescricao(atualizacao.getDescricao());
			}
			
			if(!verificador.VerificarDouble(atualizacao.getPreco())) {
				oferta.setPreco(atualizacao.getPreco());
			}
		}
	}
}
