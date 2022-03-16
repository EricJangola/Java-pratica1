<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Produtos</title>
</head>
<body>
	<center>
		<!--<h2>
        	<a href="inserirProduto.dao">Inserir Novo Produto</a>
        	&nbsp;&nbsp;&nbsp;       	        	
        </h2> -->
		<h1>Adicionar Produtos</h1>
		<form action="inserirProduto" method="POST">
			Nome: <input type="text" name="nome" id="nome">
			<br></br>
			Preco: <input type="number" step="0.01" name="preco" id="preco">
			<input type="hidden" name="categoria" value="<%= request.getParameter("categoria") %>">
			<input type="submit" value="inserirProduto">
		</form>
	</center>

    <center>
		<h1>Lista de Produtos</h1>
		<form action="produto" method="POST">
			Nome: <input type="text" name="nome" id="nome">
			<input type="submit" value="filtrar">
		</form>
		<div align="center">
			<table border="1" cellpadding="5">
				<caption><h2>Lista de Produtos</h2></caption>
				<tr>
					<th>Codigo</th>
					<th>Nome</th>
					<th>Preco</th>                              
				</tr>
				<c:forEach var="produto" items="${listaProduto}">
					<tr>
						<td><c:out value="${produto.codigo}" /></td>
						<td><c:out value="${produto.nome}" /></td>                   
						<td><c:out value="${produto.preco}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	</center>
</body>
</html>