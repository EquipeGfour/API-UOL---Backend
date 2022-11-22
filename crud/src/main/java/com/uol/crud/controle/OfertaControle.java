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
import com.uol.crud.modelo.OfertaAtualizador;
import com.uol.crud.modelo.RespostaDelete;
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.modelo.RespostaPut;
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
	
	private OfertaAtualizador atualizador = new OfertaAtualizador();
	
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
	
	
	@PutMapping("/atualizar/{id}")
	public RespostaPut atualizarOferta(@RequestBody Oferta atualizacao, @PathVariable String id) {
		Oferta OfertaSelecionada = repositorio.findById(id).orElse(null);
		String mensagem = "Oferta não encontrada.";
		if (OfertaSelecionada != null) {
			mensagem = "Oferta Atualizada com Sucesso";
			atualizador.atualizarOferta(OfertaSelecionada, atualizacao);
			repositorio.save(OfertaSelecionada);
		}
		RespostaPut resposta = new RespostaPut(id, mensagem);
		return resposta;
	}
	
	@DeleteMapping("/excluir/{id}")
	public RespostaDelete excluirOferta(@PathVariable String id) {
		Oferta dados = repositorio.findById(id).orElse(null);
		String mensagem = null;
		if(dados == null) {
			mensagem = "Oferta não encontrado.";
		}else {
			mensagem = "Oferta excluida.";
			repositorio.delete(dados);
		}
		return new RespostaDelete(id, mensagem);
	}
	
	
}
