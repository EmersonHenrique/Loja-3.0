package br.com.loja03.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja03.dao.ProdutoDao;
import br.com.loja03.model.Produto;

public class Main {
	
   public static void main(String[] args) throws SQLException {	   
	
	Main m = new Main();
	//m.test_lista();
	consultarPorId(2);
	
}

private static void consultarPorId(int i) throws SQLException {
	Connection con = CriarConexao.getConexao();
	ProdutoDao dao = new ProdutoDao(con);
	Produto p = new Produto();
	
	p.setId(i);
	System.out.println(dao.consultarPorId(i).getNome());
	
	
}

private void test_lista() throws SQLException {
	Connection con = CriarConexao.getConexao();
	ProdutoDao dao = new ProdutoDao(con);
		
	List<Produto> list = null;
	list = dao.getList();
	
	for (Produto p : list) {
		System.out.println(p.getId());
		System.out.println(p.getNome());
		System.out.println(p.getDescricao());
		System.out.println(p.getImagem());
	}
	
	
   }
}
