package br.com.estoqueartesanart.mvc.estoqueartesanart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Produtos;


@Repository
public interface ProdutosRepository extends JpaRepository <Produtos, Long>{
	
	
}
