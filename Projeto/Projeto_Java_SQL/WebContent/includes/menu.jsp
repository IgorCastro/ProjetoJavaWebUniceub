<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title> sdsdd</title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
       ul{
           display:block;
           margin:0;
           padding:0;      
       }
       ul li{
       float:left;
       display:block;
       }
       ul li ul{
       display:none; 
       }
       ul li:hover ul{
       display:block;
       }
       ul li:hover ul li{
       float:none;
       }
       ul li a{
                  text-decoration:none;
                  background:#BA55D3;
                  color:white;
                  display:block;
                  padding:5px 15px 5px;
                  margin-top:1px;
                  margin-left:1px;
                                 
       }
       ul li a:hover{
       background:#7B68EE;
       }
     
</style>
</head>
<body>

<ul>
       <li><a href="#">Menu de Opções</a>
            <ul> 
                <li><a href="usucontroller.do?acao=lis">Lista de Usuários</a></li>
                <li><a href="usucontroller.do?acao=cad">Novo Usuário</a></li>
                <li><a href="autcontroller.do"> Sair </a></li>
            </ul>
       </li>
</ul>
</body>
</html>