package com.uol.crud.controle;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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

import com.uol.crud.entidade.Categoria;
import com.uol.crud.entidade.Produto;
import com.uol.crud.modelo.ProdutoAtualizador;
import com.uol.crud.modelo.RequisicaoProdutoCategoria;
import com.uol.crud.modelo.RespostaDelete;
import com.uol.crud.modelo.RespostaGet;
import com.uol.crud.modelo.RespostaPostProdutos;
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
	public RespostaPostProdutos cadastrarProduto(@RequestBody @Valid RequisicaoProdutoCategoria requisicao) {
		Produto produto = repositorio.save(requisicao.getProduto());
		String resposta = "";
		for(Categoria categoria: requisicao.getCategorias()) {
			Categoria categoriaSelecionada = repositorioCategoria.findById(categoria.getId()).orElse(null);
			if(categoriaSelecionada == null) {
				System.out.print("Categoria não encontrada.");
				resposta += " " + categoria.getId() + " Categoria não encontrada." + System.lineSeparator();
			}else {
				categoriaSelecionada.getProdutos().add(produto);
				repositorioCategoria.save(categoriaSelecionada);
				resposta += " " +  categoriaSelecionada.getId() + " Categoria encontrada." + System.lineSeparator();
			}
		}
		return new RespostaPostProdutos(null, resposta, produto);
	}

	@PostMapping("/cadastro-multiplos")
	public RespostaPostProdutos cadastroMultiplos(@RequestBody List <Categoria> categorias) {
		List <Produto> produtos = new ArrayList<Produto>();
		RespostaPostProdutos resposta = new RespostaPostProdutos(null, "Cadastrado realizado com sucesso", null);
		for (Categoria c: categorias) {
			if (c.getId() != null) {
				Categoria cat = repositorioCategoria.findById(c.getId()).orElse(null);
				if(cat == null) {
					resposta.setId(c.getId());
					resposta.setMensagem("Categoria não encotrada.");
					return resposta;
				}else {
					cat.getProdutos().addAll(c.getProdutos());
					produtos.addAll(c.getProdutos());
					repositorio.saveAll(c.getProdutos());
					repositorioCategoria.save(cat);	
				}
			}else {
				produtos.addAll(c.getProdutos());
				repositorioCategoria.save(c);
			}
		}
		resposta.setDados(produtos);
		return resposta;
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
