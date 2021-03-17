<%-- 
    Document   : erro
    Created on : 16/02/2021, 00:41:18
    Author     : diogo11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro no sistema</title>
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
            <img src="imagens/icons8-error-52.png" alt="" width="100" height="100" class="d-inline-block align-top">
            <h1>Ocorreu um erro no sistema</h1>
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
        margin-top: 250px;
    }
    
    h1 {
        color: #8A2BE2;
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
