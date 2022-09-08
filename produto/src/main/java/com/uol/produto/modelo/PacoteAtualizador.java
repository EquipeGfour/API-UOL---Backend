package com.uol.produto.modelo;

import com.uol.produto.entidade.Pacote;

public class PacoteAtualizador {
	
	private VerificarNulo verificador = new VerificarNulo();
	
	public void atualizarPacote(Pacote pacote, Pacote atualizacao) {
		if(atualizacao != null) {
			if(!verificador.VerificarString(atualizacao.getNome())) {
				pacote.setNome(atualizacao.getNome());
			}
			
			if(!verificador.VerificarDouble(atualizacao.getPreco())) {
				pacote.setPreco(atualizacao.getPreco());
			}
			
			if(!verificador.VerificarString(atualizacao.getDescricao())) {
				pacote.setDescricao(atualizacao.getDescricao());
			}
		}
	}
}
