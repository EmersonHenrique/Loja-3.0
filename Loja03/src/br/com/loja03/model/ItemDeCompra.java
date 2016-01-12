package br.com.loja03.model;

public class ItemDeCompra {
    
	private Integer id;
	private Produto produto;
	private int quantidade;
	private double total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTotal(){
		this.total = this.quantidade * this.produto.getPrecoUnitario();
		return total;
	}
	
}
