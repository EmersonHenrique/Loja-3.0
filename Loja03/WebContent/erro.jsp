<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erro!</title>
</head>
<%
Exception erro = (Exception) request.getAttribute("erro");
%>
<body>
<h1>erro! <%=erro%></h1>
</body>
</html>