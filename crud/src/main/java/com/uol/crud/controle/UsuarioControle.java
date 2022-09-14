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
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.modelo.RespostaPost;
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
	public RespostaGet buscarUsuarioId(@PathVariable String id) {
		Usuario selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Usuario encontrado";
		if(selecionado == null) {
			mensagem = "Usuario não encontrado";
		}
		RespostaGet resposta = new RespostaGet(id, mensagem, selecionado);
		return resposta;
	}
	@PostMapping("/cadastro")
	public RespostaPost cadastroUsuario(@RequestBody @Valid Usuario usuario) {
		Usuario user = repositorio.save(usuario);
		RespostaPost resposta = new RespostaPost(user.getId(), "Usuario Criado com Sucesso");
		return resposta;
		
	}
}
