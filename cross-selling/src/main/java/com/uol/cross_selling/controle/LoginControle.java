package com.uol.cross_selling.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.cross_selling.entidade.Usuario;
import com.uol.cross_selling.modelo.RespostaLogin;
import com.uol.cross_selling.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/login")
public class LoginControle {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@PostMapping("/")
	public RespostaLogin logar(@RequestBody Usuario usuarioLogin) {
		Usuario selecionado = usuarioRepositorio.findUsuarioByEmail(usuarioLogin.getEmail());
		String mensagem = "Email ou senha não encontrado";
		if (selecionado.getSenha().contains(usuarioLogin.getSenha()))  {
			 mensagem = "Login efetuado com sucesso";
		}
				
		RespostaLogin resposta = new RespostaLogin(selecionado.getId(), mensagem , selecionado);
		return resposta;
		}

}
