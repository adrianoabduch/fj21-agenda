<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.fj21.entidades.Contato" %>
<jsp:useBean id="contatoDAO" class="br.com.fj21.dao.ContatoDAO" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edita Contato</title>
	<link rel="stylesheet" href="css/estilo.css">
</head>
<body>

	<%
		Contato contato = contatoDAO.findContatoById(new Long(pageContext.getRequest().getParameter("eid")));
	%>
	
	<form method="GET">
		<fieldset class="formulario">
			<label for="nome">Nome:</label>
			<input type="text" name="nome" value="<%= contato.getNome() %>">
			
			<label for="email">E-mail:</label>
			<input type="text" name="email" value="<%= contato.getEmail() %>">
			
			<label for="endereco">Endereço:</label>
			<input type="text" name="endereco" value="<%= contato.getEndereco() %>">
			
			<label for="dataNascimento">Data Nascimento:</label>
			<input type="text" name="dataNascimento">
			
			<div class="buttons">
				<input type="reset" value="Limpar">
				<input type="submit" value="Adicionar">
			</div>
		</fieldset>
	</form>

</body>
</html>