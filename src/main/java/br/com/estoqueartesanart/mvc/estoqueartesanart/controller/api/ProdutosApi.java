package br.com.estoqueartesanart.mvc.estoqueartesanart.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Produtos;

import br.com.estoqueartesanart.mvc.estoqueartesanart.repository.ProdutosRepository;

@RestController
@RequestMapping("/usuario")
public class ProdutosApi {
	
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping("/requisitarPedido/formulario/listar")
	public List<Produtos> getProdutos(){
		return produtosRepository.findAll();
	}
	
	
	
	
	

}
