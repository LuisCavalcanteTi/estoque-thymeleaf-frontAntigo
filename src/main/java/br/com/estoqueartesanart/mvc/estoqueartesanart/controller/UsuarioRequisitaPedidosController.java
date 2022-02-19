package br.com.estoqueartesanart.mvc.estoqueartesanart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Pedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Produtos;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.User;
import br.com.estoqueartesanart.mvc.estoqueartesanart.repository.PedidoRepository;
import br.com.estoqueartesanart.mvc.estoqueartesanart.repository.ProdutosRepository;
import br.com.estoqueartesanart.mvc.estoqueartesanart.repository.UserRepository;
import br.com.estoqueartesanart.mvc.estoqueartesanart.tdo.RequisicaoNovoPedido;

@Controller
@RequestMapping("usuario")
public class UsuarioRequisitaPedidosController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	

	@GetMapping("/requisitarPedido/formulario")
	public String RequisitarPedido(RequisicaoNovoPedido requisicao, Model model) {
		
		List<Produtos> produtos = produtosRepository.findAll();
		model.addAttribute("produtos", produtos);
		return ("htmlRequisitante/requisitarPedido");
		
		
	}
	
	


	
	
	@PostMapping("/requisitarPedido/cadastro")
	public String salvarRequisicao( @Valid  RequisicaoNovoPedido requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return ("htmlRequisitante/requisitarPedido");
			
		}
		
		
		
		
	String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
	
		Pedido pedido = requisicao.toPedido();
		pedido.setUser(user);
		pedido.setNomeDoRequisitante(user.getUsername());
		
		pedidoRepository.save(pedido);

		return "redirect:/usuario/requisitarPedido/formulario";
	}

}
