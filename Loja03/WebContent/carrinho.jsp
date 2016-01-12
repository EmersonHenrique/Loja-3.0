<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.com.loja03.model.ItemDeCompra"%>
<%@page import="br.com.loja03.model.CarrinhoDeCompra"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>carrinho</title>
</head>
<body>

  <h1>Carrinho de Compras!</h1>
<table border="1" cellpadding="2" >
<tr>
<td bgcolor="#000088"><font color="white">Excluir</font></td>
<td bgcolor="#000088"><font color="white">Item</font></td>
<td bgcolor="#000088"><font color="white">QTD</font></td>
<td bgcolor="#000088"><font color="white">Preço Unitário</font></td>
<td bgcolor="#000088"><font color="white">Total Item</font></td>
<td bgcolor="#000088"><font color="white">+1</font></td>
</tr>
<%
//recupera os produtos do carrinho da sessao
CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");
for(ItemDeCompra item : carrinho.getItens()){
%>
<tr>
<td><a href="ControleCarrinho?acao=removeProduto&idProduto=<%=item.getProduto().getId()%>">X</td>
<td><%=item.getProduto().getNome() %></td>
<td><%=item.getQuantidade() %></td>
<td><%=item.getProduto().getPrecoUnitario() %></td>
<td><%=item.getTotal()%></td>
<td><a href="ControleCarrinho?acao=addProduto&idProduto=<%=item.getProduto().getId()%>">+</a></td>
</tr>
<%
}
%>
</table>
<strong>Valor Total: <%=carrinho.calculaTotal() %></strong><br/>
<a href="index.jsp"> Continue comprando</a><br/>

<a href="ControleCarrinho?acao=cancelaCompra">Cancelar comprar</a>

</body>
</html>