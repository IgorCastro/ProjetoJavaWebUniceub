<!DOCTYPE html>
<%@page import="projetotava.entidades.Usuario"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>
</head>
<body>

	<%
	//Converte o string usuario , para um Objeto
	Usuario usuario = (Usuario)request.getAttribute("usuario");
	
	%>

	<form action="usucontroller.do" method="post">
	
		
		<label >ID : </label>
		<input type="text" name="txtid" value="<%=usuario.getId() %>" size="20"/><br>
		<label >Nome : </label>
		<input type="text" name="txtnome" value="<%=usuario.getNome() %>" size="20"/><br>
		<label> Login : </label>
		<input type="text" name="txtlogin" value="<%=usuario.getLogin() %>" size="20"/><br>
		<label>Senha:</label>
		<input type="password" name="txtsenha" value="<%=usuario.getSenha() %>" maxlength="6" size="20"/><br>
		
		<input type="submit" value="Salvar"/><br>
	
	
	</form>
</body>
</html>