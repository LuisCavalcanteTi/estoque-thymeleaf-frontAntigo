package br.com.estoqueartesanart.mvc.estoqueartesanart.controller.form;


import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Pedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.model.StatusPedido;

public class AtualizarStatusImpresso {
	
	private StatusPedido status ;

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	public Pedido atualizarStatus() {
		Pedido pedido =  new Pedido();
		
		pedido.setStatus(StatusPedido.IMPRESSO);
		return pedido;
	}


}
