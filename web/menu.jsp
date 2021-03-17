<%-- 
    Document   : menu
    Created on : 15/02/2021, 21:48:05
    Author     : diogo11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String contagem = (String) session.getServletContext().getAttribute("userCounter"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#" id="anchor">
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
        <div class="insidemenu">
            <jsp:include page="adrotator.jsp" flush="true" />
            <p id="contador"><%= contagem %> usuário(s) logado(s)</p>
        </div>
    </body>
</html>

<style>
    body {
        background-color: #F0FFFF;
    }
    
    .menu {
        display: flex;
        justify-content: center;
    }
    
    .insidemenu {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        margin: 0 200px 200px 200px;
        border-radius: 10px;
    }
    
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
    
    #contador {
        font-weight: 500;
        color: #8A2BE2;
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
