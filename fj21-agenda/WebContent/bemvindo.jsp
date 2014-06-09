<html>
	<body>
		<%-- Comentários no JSP --%>
		<%
			String mensagem = "Bem vindo ao primeiro JSP.";
		%>
		
		Mensagem = <%= mensagem %>
		
		<% out.print(pageContext.getRequest().getParameter("teste")); %>
		
		${param.teste}		
		
	</body>
</html>