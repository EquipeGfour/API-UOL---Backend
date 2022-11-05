package com.uol.crud.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Oferta;
import com.uol.crud.entidade.Pacote;
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.repositorio.OfertaRepositorio;
import com.uol.crud.repositorio.PacoteRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/oferta")
public class OfertaControle {
	
	@Autowired
	private OfertaRepositorio repositorio;
	@Autowired
	private PacoteRepositorio pacoteRepositorio;
	
	@GetMapping("/buscar")
	public List<Oferta> buscarOfertas(){
	    return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public RespostaGet buscarOfertaPorId(@PathVariable String id) {
	    Oferta selecionado = repositorio.findById(id).orElse(null);
	    String mensagem = "Oferta encontrada";
	    if(selecionado == null) {
	        mensagem = "Oferta não encontrada.";
	    }
	    RespostaGet resposta = new RespostaGet(id, mensagem, selecionado);
	    return resposta;
	}
	
	@PostMapping("/cadastrar-multiplos")
	public void cadastrarOfertas(@RequestBody List <Oferta> ofertas) {
		for(Oferta oferta: ofertas) {
			List <Pacote> pacotes = new ArrayList<Pacote>();
			for(Pacote pacote: oferta.getPacotes()) {
				Pacote pacoteEncontrado = pacoteRepositorio.findById(pacote.getId()).orElse(null);
				if(pacoteEncontrado != null) {
					System.out.print(pacote.getPreco());
					if (pacote.getPreco() != null ) {
						pacoteEncontrado.setPreco(pacote.getPreco());
					}
					pacotes.add(pacoteEncontrado);
				}
			}
			oferta.setPacotes(pacotes);
		}
		repositorio.saveAll(ofertas);
		
	}
	
	
	//@PutMapping("/atualizar/{id}")
	
	//@DeleteMapping("/excluir/{id}")
	
	
}
