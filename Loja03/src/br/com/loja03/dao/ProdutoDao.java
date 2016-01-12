package br.com.loja03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja03.model.Produto;



public class ProdutoDao {
	
	private Connection con;

	public ProdutoDao(Connection con) {
		this.con = con;
	}
//----------------------------------------------------------------------------------------------------------------------------------------	
	public List<Produto> getList() {

		try {
			String sql = "select * from produto";

			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();

			List<Produto> minhaLista = new ArrayList<Produto>();
			while (rs.next()) {
				Produto prod = new Produto();

				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setPrecoUnitario(rs.getDouble("precoUnitario"));
				prod.setImagem(rs.getString("imagem"));
				minhaLista.add(prod);
			}

			smt.close();
			rs.close();

			return minhaLista;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }

	   }
	//-------------------------------------------------------------------------------------------------------------------------
	
	public Produto consultarPorId(int id) {
		
		Produto prod = new Produto();
		try {			
			String sql = "select * from produto where id = ?";			
            
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setInt(1, id);
			ResultSet rs = smt.executeQuery();

			rs.next();			

				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setPrecoUnitario(rs.getDouble("precoUnitario"));
				prod.setImagem(rs.getString("imagem"));		
			
		} catch (SQLException ex1) {
			throw new RuntimeException(ex1);
			} finally {
			try{
			if(con!=null){
			con.close();
			}
			}catch(SQLException ex2){
			throw new RuntimeException(ex2);
			}
			}
			
			return prod;			

	   }
	//-------------------------------------------------------------------------------------------------------------------------
	}
