package br.com.loja03.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.loja03.dao.ProdutoDao;
import br.com.loja03.model.CarrinhoDeCompra;
import br.com.loja03.model.ItemDeCompra;
import br.com.loja03.model.Produto;
import br.com.loja03.util.CriarConexao;

@WebServlet("/ControleCarrinho")
public class ControleCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ControleCarrinho() {
        super();   }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	try{
    		String acao = request.getParameter("acao");
    		
    		if(acao.equals("addProduto")){
    			int idProduto = Integer.parseInt(request.getParameter("idProduto"));
    			boolean existe = false;
    			
    			HttpSession sessao = request.getSession();
    			
    			//recupera um carrinho de produtos da sessão
    			//se não exite um carrinho na sessão o valor será igual a null
    			CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
    			
    			if(carrinho==null){
    				carrinho = new CarrinhoDeCompra();
    				sessao.setAttribute("carrinho", carrinho);
    			}
    			if(carrinho.getItens()!=null){
    				for(ItemDeCompra item:carrinho.getItens()){
    					if(item.getProduto().getId()==idProduto){
    						item.setQuantidade(item.getQuantidade()+1);
    						existe=true;
    					}
    				}
    			}
    			if(existe==false){
    				Connection con = CriarConexao.getConexao();
    				Produto produto = new ProdutoDao(con).consultarPorId(idProduto);
    				
    				ItemDeCompra novoItem = new ItemDeCompra();
    				novoItem.setProduto(produto);
    				novoItem.setQuantidade(1);
    				
    				carrinho.addNovoItem(novoItem);
    			}
    			
    			request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
    		}
    		else if(acao.equals("removeProduto")){
    			
    			HttpSession sessao = request.getSession();
    			
    			CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
    			
    			int idProduto = Integer.parseInt(request.getParameter("idProduto"));
    			
    			ItemDeCompra itemRemove = new ItemDeCompra();
    			Produto prodRemove = new Produto();
    			prodRemove.setId(idProduto);
    			itemRemove.setProduto(prodRemove);
    			
    			carrinho.removeItem(itemRemove);
    			request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
    		
    		}else if(acao.equals("cancelaCompra")){
    			HttpSession sessao = request.getSession();
    			sessao.removeAttribute("carrinho");
    			response.sendRedirect("index.jsp");
    		}
    	}catch (Exception erro) {
			 request.setAttribute("erro", erro);
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
