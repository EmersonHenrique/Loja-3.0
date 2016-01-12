<%@page import="java.util.List"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.com.loja03.model.Produto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
<%
// Recupera os produtos.
java.util.List<Produto> produtos = (java.util.List<Produto>) request.getAttribute("produtos");
if(produtos == null) {
request.getRequestDispatcher("/ControleProduto?acao=listaProdutos").forward(request, response);
}
%>
<h1>Lista de Produtos</h1>
<table border="0" cellpadding="5" align="center">
<%
int contadorColuna=1;
for(Produto produto : produtos){
//se é o primeiro produto, cria o inicio da linha
if(contadorColuna == 1) {
out.println("<tr>");
}
%>
<td align="center" valign="bottom"> <img src="imagens/<%=produto.getImagem()%>" alt="<%=produto.getImagem()%>"/> <br/> 
<%=produto.getNome()%><br/> 
<a href="ControleCarrinho?acao=addProduto&idProduto=<%=produto.getId()%>"> Comprar</a></td>
<%
//se é o último produto, exibir o término da linha
if(contadorColuna == 3){
out.println("</tr>");
contadorColuna =0;
}
//atualiza o contador de colulas
contadorColuna ++;
}//fim do for
%>
</table>       
    </body>
</html>