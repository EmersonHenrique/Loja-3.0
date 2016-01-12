package br.com.loja03.model;

import java.util.*;

public class CarrinhoDeCompra {
	
	private Integer id;
	private List<ItemDeCompra> itens;
	private double total;
	
	public void addNovoItem(ItemDeCompra item){
		if(this.itens==null){
			this.itens = new ArrayList<ItemDeCompra>();
		}
		this.itens.add(item);
	}
  public void removeItem(ItemDeCompra itemRemove){
	  for(Iterator i = itens.iterator();i.hasNext();){
		  ItemDeCompra item = (ItemDeCompra) i.next();
		  if(item.getProduto().getId()==itemRemove.getProduto().getId()){
			  i.remove();
		  }
	  }
  }
  public double calculaTotal(){
	  double vtotal=0;
	  for(ItemDeCompra item: this.itens){
		  vtotal += item.getTotal();
	  }
	  this.total = vtotal;
	  return total;
  }
public Integer getId() {
	return id;
}

public List<ItemDeCompra> getItens() {
	return itens;
}

public double getTotal() {
	return total;
  }
 
}
