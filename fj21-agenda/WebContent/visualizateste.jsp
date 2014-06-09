<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="contatoDAO" class="br.com.fj21.dao.ContatoDAO" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Endereço</th>
				<th>E-mail</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="<%= contatoDAO.getLista() %>" var="c">
				<tr>
					<td>${c.nome}</td>
					<td>${c.endereco}</td>
					<td>${c.email}</td>
					<td>
						<fmt:formatDate value="${c.dataNascimento}" pattern="dd/MM/yyyy	" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>