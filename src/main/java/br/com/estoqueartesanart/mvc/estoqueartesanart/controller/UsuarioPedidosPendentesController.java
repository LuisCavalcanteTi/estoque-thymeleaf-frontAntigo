package br.com.estoqueartesanart.mvc.estoqueartesanart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Pedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.model.StatusPedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.repository.PedidoRepository;

@Controller
public class UsuarioPedidosPendentesController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/usuario/pedidosPendentes")
	public String PedidosPendentesUsuario(Model model) {

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.PENDENTE);
		model.addAttribute("pedidos", pedidos);

		return ("htmlRequisitante/pedidosPendentes");
	}

}
