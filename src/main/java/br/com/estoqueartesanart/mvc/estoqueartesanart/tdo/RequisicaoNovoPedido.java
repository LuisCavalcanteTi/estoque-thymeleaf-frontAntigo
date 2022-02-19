package br.com.estoqueartesanart.mvc.estoqueartesanart.tdo;





import java.util.Calendar;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.Pedido;
import br.com.estoqueartesanart.mvc.estoqueartesanart.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@NotBlank @NotNull @Size(min = 3, max = 80)
	private String codigoProduto;
	 
	@NotBlank @NotNull @Size(min = 3, max = 80)
	private String descricao;
	@NotBlank @NotNull @Size(min = 3, max = 20)
	private String quantidade;
	@NotBlank @NotNull @Size(min = 3, max = 20)
	private String medida;
	
	
	private String horaRequisicao;
	private String quantidadeEntregue;
	private String horaImpresso;
	private String horaFinalizacao;
    String dataInicio;
	
	
	
	public String getHoraRequisicao() {
		return horaRequisicao;
	}
	public void setHoraRequisicao(String horaRequisicao) {
		this.horaRequisicao = horaRequisicao;
	}
	public String getQuantidadeEntregue() {
		return quantidadeEntregue;
	}
	public void setQuantidadeEntregue(String quantidadeEntregue) {
		this.quantidadeEntregue = quantidadeEntregue;
	}
	public String getHoraImpresso() {
		return horaImpresso;
	}
	public void setHoraImpresso(String horaImpresso) {
		this.horaImpresso = horaImpresso;
	}
	public String getHoraFinalizacao() {
		return horaFinalizacao;
	}
	public void setHoraFinalizacao(String horaFinalizacao) {
		this.horaFinalizacao = horaFinalizacao;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	
	
	public Pedido toPedido() {
		java.util.Date novaData;
		Calendar c = Calendar.getInstance();
		novaData =   c.getTime();
		String data = String.valueOf(novaData);
		dataInicio = data;
		
		Pedido pedido =  new Pedido();
		
		pedido.setCodigoProduto(codigoProduto);
		pedido.setDescricao(descricao);
		pedido.setQuantidade(quantidade);
		pedido.setMedida(medida);
		pedido.setHoraRequisicao(data);
		pedido.setStatus(StatusPedido.PENDENTE);
		
		pedido.setSetorDoRequisitante("TI");
		return pedido;

	}
	
	
	
	public Pedido update() {
					
		Pedido pedido =  new Pedido();
		

		return pedido;
		
		
	}
	
	
	
	
	
public Pedido updateFinalizado() {
	 java.util.Date novaData;
	 Calendar c = Calendar.getInstance();
	 novaData =   c.getTime();
	 String data = String.valueOf(novaData);
		
		
	
		
		Pedido pedido =  new Pedido();
		
		
		pedido.setId(id );
		pedido.setCodigoProduto(codigoProduto);
		pedido.setDescricao(descricao);
		pedido.setQuantidade(quantidade);
		pedido.setMedida(medida);
		pedido.setHoraRequisicao(horaRequisicao);
		pedido.setQuantidadeEntregue(quantidadeEntregue);
		pedido.setHoraImpresso(horaImpresso);
		pedido.setHoraFinalizacao(data);
		pedido.setNomeDoFinalizante("LUCAS");
		pedido.setSetorDoRequisitante("ESTOQUE");
		pedido.setNomeDoRequisitante("LUIS");
		
		pedido.setStatus(StatusPedido.FINALIZADO);
		return pedido;
		
		
	}


}
