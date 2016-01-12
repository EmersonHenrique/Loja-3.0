package br.com.loja03.util;

import java.sql.*;

public class CriarConexao {
	public static Connection getConexao() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("conectou");
			return DriverManager.getConnection("jdbc:mysql://localhost/lojavirtual","root","123");
		}  catch (SQLException e) {
			throw new SQLException(e);
		}catch (ClassNotFoundException e1) {
			throw new SQLException(e1);
			}	
	
	}
}
