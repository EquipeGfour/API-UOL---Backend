package com.uol.cross_selling.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.cross_selling.entidade.Usuario;
import com.uol.cross_selling.modelo.RespostaLogin;
import com.uol.cross_selling.repositorio.UsuarioRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginControle {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@PostMapping("/")
	public RespostaLogin logar(@RequestBody Usuario usuarioLogin) {
		Usuario selecionado = usuarioRepositorio.findUsuarioByEmail(usuarioLogin.getEmail());
		if(selecionado == null) {
			RespostaLogin resposta = new RespostaLogin("Email ou senha não encontrado" ,null,  null);
			return resposta;
		}
		if (selecionado.getSenha().equals(usuarioLogin.getSenha()))  {
			 RespostaLogin resposta = new RespostaLogin("Login efetuado com sucesso" ,selecionado.getId(),  selecionado);
			 return resposta;
		}
		else {
			RespostaLogin resposta = new RespostaLogin("Email ou senha não encontrado" ,selecionado.getId(),  null);
			return resposta;
		}
	}

}
