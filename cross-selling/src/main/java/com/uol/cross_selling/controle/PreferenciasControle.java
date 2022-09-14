package com.uol.cross_selling.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.cross_selling.entidade.Categoria;
import com.uol.cross_selling.repositorio.CategoriaRepositorio;

@RestController
@RequestMapping("/interesse")
public class PreferenciasControle {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@PostMapping("/preferencias-usuario")
	public List<Categoria> preferenciasUsuario(@RequestBody List<Categoria> usuarioInteresses){
		List<Categoria> categorias = categoriaRepositorio.findAll();
		List<Categoria> interesses = new ArrayList<Categoria>();
		for(Categoria categoriaInteresse : usuarioInteresses) {
			for(Categoria categoria : categorias) {
				if(categoria.getId().contains(categoriaInteresse.getId())) {
					interesses.add(categoria);
				}
			}
		}
		return interesses;
	}
} 
