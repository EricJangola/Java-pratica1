<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir Produtos</title>
</head>
<body>
    <center>
		<h1>Inserir Produtos</h1>
		<form action="produto" method="POST">
			Nome: <input type="text" name="nome" id="nome">
			<input type="submit" value="Inserir">
			Preco: <input type="number" step="0.01" name="preco" id="preco">
			<input type="submit" value="Inserir">
		</form>
		<a href="index.jsp"> Voltar </a>
	</center>
</body>
</html>