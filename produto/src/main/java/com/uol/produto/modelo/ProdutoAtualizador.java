package com.uol.produto.modelo;

import com.uol.produto.entidade.Produto;

public class ProdutoAtualizador {
	
	private VerificarNulo verificador = new VerificarNulo();
	
	public void atualizarProduto(Produto produto, Produto atualizacao) {
		
		if(atualizacao != null) {

			if(!verificador.VerificarString(atualizacao.getNome())) {
				produto.setNome(atualizacao.getNome());
			}

			if(!verificador.VerificarString(atualizacao.getDescricao())) {
				produto.setDescricao(atualizacao.getDescricao());
			}

			if(!verificador.VerificarDouble(atualizacao.getPreco())) {
				produto.setPreco(atualizacao.getPreco());
			}
		}
	}

}
