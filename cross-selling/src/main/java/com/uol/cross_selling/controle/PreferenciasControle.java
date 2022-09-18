package com.uol.cross_selling.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.cross_selling.entidade.Categoria;
import com.uol.cross_selling.entidade.Usuario;
import com.uol.cross_selling.modelo.RespostaGet;
import com.uol.cross_selling.modelo.RespostaPreferencias;
import com.uol.cross_selling.repositorio.CategoriaRepositorio;
import com.uol.cross_selling.repositorio.UsuarioRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/interesse")
public class PreferenciasControle {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	@Autowired
    private CategoriaRepositorio categoriaRepositorio;
	
	
	@GetMapping("/preferencias-usuario/{id}")
	public RespostaGet preferenciasUsuario(@PathVariable String id){
		
		String mensagem = "Usuario Encontrado";
		Usuario selecionado = repositorio.findById(id).orElse(null);
		if(selecionado == null) {
			mensagem = "Usuario não Encontrado.";
		}
		RespostaGet resposta = new RespostaGet(mensagem,id,selecionado.getInteresses());
		return resposta;
	}
	
	@GetMapping("/preferencias/{id}")
    public RespostaPreferencias preferenciasUser(@PathVariable String id){
		List<Categoria> categorias = categoriaRepositorio.findAll();
		List<Categoria> semInteresses = new ArrayList<Categoria>(categorias);
		Usuario selecionado = repositorio.findById(id).orElse(null);
        List<Categoria> interesses = new ArrayList<Categoria>();
        String mensagem = "Usuario não encontrado";
        if(selecionado != null) {  
        	mensagem = "Usuario encontrado";
        	for(Categoria categoriaInteresse : selecionado.getInteresses()){
        		for(Categoria categoria : categorias) {
        			if(categoria.getId().contains(categoriaInteresse.getId())) {
        				interesses.add(categoria);
        				Categoria acharCategoria = semInteresses.stream().filter(c -> categoria.getId().equals(c.getId())).findAny().orElse(null);
        				if(acharCategoria != null) {	
        					semInteresses.remove(acharCategoria);
        				}
        				
        			}
        		}
        	}
        }
        RespostaPreferencias resposta = new RespostaPreferencias(mensagem, id, semInteresses, interesses);
        return resposta;       
    }
} 
