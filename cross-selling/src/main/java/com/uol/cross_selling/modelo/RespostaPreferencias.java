package com.uol.cross_selling.modelo;

import java.util.List;

import com.uol.cross_selling.entidade.Categoria;

public class RespostaPreferencias extends Resposta{
	
	private List<Categoria> categorias;
	private Object interesses;

	public RespostaPreferencias(String mensagem, String id, List<Categoria> categorias, Object interesses) {
		super(mensagem, id);
		this.categorias = categorias;
		this.interesses = interesses;
	}

	public Object getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Object getInteresses() {
		return interesses;
	}

	public void setInteresses(Object interesses) {
		this.interesses = interesses;
	}

}
