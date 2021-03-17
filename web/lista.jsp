<%-- 
    Document   : lista
    Created on : 16/02/2021, 00:41:32
    Author     : diogo11
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAOUsuario"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="NewServlet3?operacao=Logar" id="anchor">
                  <img src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Bootstrap_logo.svg" alt="" width="30" height="24" class="d-inline-block align-top" id="image">
                  Bootstrap
                </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="NewServlet3?operacao=lista" id="anchorItem">Cadastro de usuários</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="NewServlet3?operacao=erro" id="anchorItem">Erro</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="NewServlet3?operacao=erro_java" id="anchorItem">Erro Java</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="NewServlet3?operacao=sair" id="anchorItem">Sair</a>
                    </li>
                </ul>
            </div>
            </div>
        </nav>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        <div id="bodyContainer">
            <div id="insideContainer">
                <div id="divmargin">
                    <%
                           DAOUsuario da = new DAOUsuario(1, "diogo", "diogo");
                           Vector<String> temp = da.buscarUsuarios();
                           for(int i = 0; i < temp.size(); i++){
                    %>
                    <div id="pcontainer">
                        <p id="users"><%= temp.get(i) %></p>
                    <div>
                    <%   
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>

<style>
    .container-fluid {
        background-color: #8A2BE2;        
    }
    
    #anchor {
        color: white;
    }
    
    #anchorItem {
        color: white;
    }
    
    #image {
        margin-top: 4px;
    }
    
    #bodyContainer {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 200px;
    }
    
    #insideContainer {
        background-color: #F0F8FF;
        border-radius: 5px;
    }
    
    #divmargin {
        margin: 50px;
    }
    
    #users {
        margin: 35px;
        color: #8A2BE2;
        font-weight: 500;
        color: #8A2BE2;
        font-size: 25px;
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
