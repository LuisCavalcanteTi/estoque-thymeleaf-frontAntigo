package br.com.estoqueartesanart.mvc.estoqueartesanart.tdo;



public class VerProdutos {
	
	
	
	

	private Long id;
	private String codigo;
	private String descricao;

	
	
	Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
