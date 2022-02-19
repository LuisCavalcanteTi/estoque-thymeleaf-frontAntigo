package br.com.estoqueartesanart.mvc.estoqueartesanart.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Pedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.model.StatusPedido;




@Repository
public interface PedidoRepository  extends JpaRepository <Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido status);

	

	
	

	
	
	

	

	
	

}
