package com.uol.crud.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Usuario;
import com.uol.crud.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@GetMapping("/usuarios")
	public List<Usuario> buscarUsuarios(){
		return repositorio.findAll();
	}
	@GetMapping("/usuario/{id}")
	public Usuario buscarUsuarioId(@PathVariable String id) {
		return repositorio.findById(id).orElse(null);
	}
	@PostMapping("/cadastro")
	public void cadastroUsuario(@RequestBody @Valid Usuario usuario) {
		repositorio.save(usuario);
		
	}
}
