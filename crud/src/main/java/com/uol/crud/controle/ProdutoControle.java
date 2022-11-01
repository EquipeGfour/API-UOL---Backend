package com.uol.crud.controle;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.crud.entidade.Categoria;
import com.uol.crud.entidade.Produto;
import com.uol.crud.modelo.ProdutoAtualizador;
import com.uol.crud.modelo.RespostaDelete;
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.modelo.RespostaPost;
import com.uol.crud.modelo.RespostaPut;
import com.uol.crud.repositorio.CategoriaRepositorio;
import com.uol.crud.repositorio.ProdutoRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/produto")
public class ProdutoControle {
	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	@Autowired
	private CategoriaRepositorio repositorioCategoria;
	
	private ProdutoAtualizador atualizador = new ProdutoAtualizador();
	
	@GetMapping("/buscar")
	public List<Produto> buscarProdutos() {
		return repositorio.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public RespostaGet obterProdutoID(@PathVariable String id) {
		Produto selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Produto encontrado";
		if(selecionado == null) {
			mensagem = "Produto não encontrado";
		}
		RespostaGet resposta = new RespostaGet(id, mensagem, selecionado);
		return resposta;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrarProduto(@RequestBody @Valid List <Categoria> categorias) {
		
		Produto prod = new Produto ();
		for(Categoria c: categorias) {
			Categoria categoriaSelecionada = repositorioCategoria.findById(c.getId()).orElse(null);
			if (categoriaSelecionada == null) {
				System.out.print("Categoria não encotrada");
			}else {
				for(Produto p : c.getProdutos()) {
					if(prod.getId() == null) {
						prod = repositorio.save(p);
					}else {
						System.out.print("Produto ja cadastrado");
					}						
				}
				categoriaSelecionada.getProdutos().add(prod);
				repositorioCategoria.save(categoriaSelecionada);
			}
		}
	}
		
	@PostMapping("/cadastro-multiplos")
	public List <Produto>  cadastroMultiplos(@RequestBody List <Categoria> categorias) {
		List <Produto> produtos = new ArrayList<Produto>();
		for (Categoria c: categorias) {
			if (c.getId() != null) {
				
				Categoria cat = repositorioCategoria.findById(c.getId()).orElse(null);
				if(cat == null) {
					System.out.print ("Não encontrado");
				}else {
					cat.getProdutos().addAll(c.getProdutos());
					produtos.addAll(c.getProdutos());
					repositorioCategoria.save(cat);	
				}
				
			}else {
				produtos.addAll(c.getProdutos());
				repositorioCategoria.save(c);
			}
		}	
		repositorio.saveAll(produtos);	
		return produtos ;
	}

	
	@PutMapping("/atualizar/{id}")
	public RespostaPut atualizarProduto(@RequestBody Produto atualizacao, @PathVariable String id ) {
		Produto selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Produto não encontrado.";
		if(selecionado != null){
			mensagem = "Produto Atualizado com Sucesso";
			atualizador.atualizarProduto(selecionado, atualizacao);
			repositorio.save(selecionado);
		}
		RespostaPut resposta = new RespostaPut(id, mensagem);
		return resposta;
	}
	
	@DeleteMapping("/excluir/{id}")
	public RespostaDelete excluirProduto(@PathVariable String id) {
		Produto selecionado = repositorio.findById(id).orElse(null);
		String mensagem = "Produto não encontrado.";
		if(selecionado != null) {
			mensagem = "Produto excluido.";
			repositorio.delete(selecionado);
		}
		RespostaDelete resposta = new RespostaDelete(id, mensagem);
		return resposta;
	}
	
}
