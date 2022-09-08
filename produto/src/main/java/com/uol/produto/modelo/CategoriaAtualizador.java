package com.uol.produto.modelo;

import com.uol.produto.entidade.Categoria;

public class CategoriaAtualizador {
	
	private VerificarNulo verificador = new VerificarNulo();
	
	public void atualizarCategoria(Categoria categoria, Categoria atualizacao) {
		if(atualizacao != null) {
			if(!verificador.VerificarString(atualizacao.getNome())) {
				categoria.setNome(atualizacao.getNome());
			}
		}
			
	}

}
