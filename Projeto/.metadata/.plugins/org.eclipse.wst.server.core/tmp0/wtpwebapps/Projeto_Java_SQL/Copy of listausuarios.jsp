<%@page import="projetotava.UsuarioController.usucontroller"%>
<%@page import="projetotava.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
</head>
<body>


		<table border="1">
			<tr bgcolor = "#EAEAEA">  <!--Delimita a tabela  -->
			<th> ID </th> <th> Nome </th> <th> Login </th> <th> Senha </th>  <th>  Ação</th> 
			</tr>
			<!-- <th> = cabeçalho das colunas da tabela -->
<%
//Converte a string lista, para um obejto, a ser passado para o usuario
//Passa as informações para o get da classe Usuariocontroller
//ScripLet = Java bruto, seco,feito a mão.

ArrayList<Usuario> lista = ( ArrayList<Usuario> )request.getAttribute("lista");

for(Usuario usu : lista){
%>	
	
	<tr>
		<td> <%=usu.getId() %> </td>
		<td> <% out.print(usu.getNome()); %> </td>
		<td> <%= usu.getLogin()%></td>
		<td> <%=usu.getSenha() %></td>
		<td> 
		<a href = "usucontroller.do?acao=exc&id=<%= usu.getId() %>"> Excluir </a>
		|
		<a href = "usucontroller.do?acao=alt&id=<%= usu.getId() %>"> Alterar </a>
		</td>
	</tr>
	<!-- o sinal de "=" faz o mesmo papel do  out.print. Ele é como se fosse um atalho-->
<% 
}

%>


		
		
		
		
		</table>

</body>
</html>