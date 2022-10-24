package com.uol.crud.modelo;

import java.util.List;

import com.uol.crud.entidade.Categoria;

public class RespostaPostCategorias extends Resposta{
    
    private List<Categoria> categorias;

    public RespostaPostCategorias(String id, String mensagem, List<Categoria> categorias) {
        super(id, mensagem);
        this.setCategorias(categorias);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
