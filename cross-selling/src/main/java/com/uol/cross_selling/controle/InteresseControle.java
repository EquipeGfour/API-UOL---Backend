package com.uol.cross_selling.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.cross_selling.entidade.Categoria;
import com.uol.cross_selling.entidade.Usuario;
import com.uol.cross_selling.repositorio.CategoriaRepositorio;
import com.uol.cross_selling.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/perfil")
public class InteresseControle {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@PutMapping("/mapear/{idUsuario}")
	public void mapeamentoPerfil (@RequestBody List<Categoria> categorias, @PathVariable String idUsuario) {
		Usuario usuarioSelecionado = usuarioRepositorio.findById(idUsuario).orElse(null);
		usuarioSelecionado.getInteresses().addAll(categorias);
		usuarioRepositorio.save(usuarioSelecionado);
	}

}
