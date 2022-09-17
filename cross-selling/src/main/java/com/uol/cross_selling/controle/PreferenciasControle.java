package com.uol.cross_selling.controle;

import java.util.ArrayList;
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
    public List<Categoria> preferenciasUser(@PathVariable String id){
		List<Categoria> categorias = categoriaRepositorio.findAll();
		Usuario selecionado = repositorio.findById(id).orElse(null);
        List<Categoria> interesses = new ArrayList<Categoria>();
        for(Categoria categoriaInteresse : selecionado.getInteresses()){
            for(Categoria categoria : categorias) {
                if(categoria.getId().contains(categoriaInteresse.getId())) {
                    interesses.add(categoria);
               }
            }
        }
        return interesses;       
    }
} 
