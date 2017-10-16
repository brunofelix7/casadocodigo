<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Livros de Java, Android e muito mais - Casa do Código</title>
</head>
<body>
	<h2>Lista de Produtos</h2>
	<hr/>
	<div>${sucesso}</div>
	<a href="/casadocodigo/produtos/form">Novo</a>
	<a href="/casadocodigo">Voltar</a>
	<br/><br/>
	<table>
		<thead>
			<tr>
				<td>Título</td>
				<td>Descrição</td>
				<td>Preços</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.titulo}</td>
					<td>${produto.descricao}</td>
					<td>${produto.paginas}</td>
				</tr>
			</c:forEach>
	</tbody>
	</table>
</body>
</html>
