package br.com.estoqueartesanart.mvc.estoqueartesanart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Pedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.model.StatusPedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.repository.PedidoRepository;
import br.com.estoqueartesanart.mvc.estoqueartesanart.tdo.RequisicaoNovoPedido;

@Controller
@RequestMapping("estoque")
public class EstoquePedidosImpressosController {

	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping("pedidosImpressos/mostrar")
	public String pedidosImpressos(Model model) {
	
	

		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.IMPRESSO);
		model.addAttribute("pedidos", pedidos);
		
		return ("htmlEstoque/pedidosImpressosEstoque");
		
		
	
	
	}
	
	@PostMapping("cadastro")
	public String updateFinalizado(RequisicaoNovoPedido requisicao ) {
		
		Pedido pedido = requisicao.updateFinalizado();
		pedidoRepository.save(pedido);

		
		
	return "redirect:/estoque/pedidosImpressos/mostrar";
	}
}
