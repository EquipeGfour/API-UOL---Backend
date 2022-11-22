package com.uol.crud.controle;

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
import com.uol.crud.modelo.RequisicaoProdCat;
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
	public void cadastroMultiplos(@RequestBody List <RequisicaoProdCat> requisicoes) {
		for(RequisicaoProdCat req: requisicoes) {
			repositorio.save(req.getProduto());
			for(Categoria categoria: req.getCategorias()) {
				Categoria categoriaSelecionada = repositorioCategoria.findById(categoria.getId()).orElse(null);
				if(categoriaSelecionada == null) {
					System.out.print("Categoria não encontrada.");
				}else {
					categoriaSelecionada.getProdutos().add(req.getProduto());
					repositorioCategoria.save(categoriaSelecionada);
				}
			}
		}
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
