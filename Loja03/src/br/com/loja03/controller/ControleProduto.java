package br.com.loja03.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja03.dao.ProdutoDao;
import br.com.loja03.model.Produto;
import br.com.loja03.util.CriarConexao;


@WebServlet("/ControleProduto")
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ControleProduto() {   }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	try{
    	String acao = request.getParameter("acao");
    	if(acao.equals("listaProdutos")){
    		Connection con = CriarConexao.getConexao();
    		
    		ArrayList<Produto> produtos = (ArrayList<Produto>) new ProdutoDao(con).getList();
    		
    		request.setAttribute("produtos", produtos);    		
    		request.getRequestDispatcher("/index.jsp").forward(request, response);    		
    	}
		
	}catch (Exception erro) {
		request.setAttribute("erro",erro);    		
		request.getRequestDispatcher("erro.jsp").forward(request, response);
	  }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
		
	}

}
