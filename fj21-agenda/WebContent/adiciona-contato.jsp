<html>
<head>
	<link rel="stylesheet" href="css/estilo.css">
</head>

	<body>
		
		<form action="adicionaContato" method="GET">
			<fieldset class="formulario">
				<label for="nome">Nome:</label>
				<input type="text" name="nome">
				
				<label for="email">E-mail:</label>
				<input type="text" name="email">
				
				<label for="endereco">Endereço:</label>
				<input type="text" name="endereco">
				
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