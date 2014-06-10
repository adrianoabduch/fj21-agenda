<%@ taglib tagdir="/WEB-INF/tags"  prefix="a" %>

<html>
<head>
	<link rel="stylesheet" href="css/estilo.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
	<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
</head>

	<body>
		
		<form action="service" method="POST">
			<fieldset class="formulario">
				<input type="hidden" name="logica" value="SalvaContato" />
				
				<label for="nome">Nome:</label>
				<input type="text" name="nome">
				
				<label for="email">E-mail:</label>
				<input type="text" name="email">
				
				<label for="endereco">Endereço:</label>
				<input type="text" name="endereco">
				
				<a:campoData id="dataNascimento" label="Data de Nascimento"></a:campoData>
				
				<div class="buttons">
					<input type="reset" value="Limpar">
					<input type="submit" value="Adicionar">
				</div>
			</fieldset>
		</form>
	</body>
</html>