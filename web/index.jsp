<%-- 
    Document   : login
    Created on : 16/02/2021, 00:40:56
    Author     : diogo11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String mensagem = (String) session.getAttribute("msg"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Olá</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <div>
            <nav class="navbar navbar-light bg-light">
              <div class="container-fluid">
                <a class="navbar-brand" href="#" id="anchor">
                  <img src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Bootstrap_logo.svg" alt="" width="30" height="24" class="d-inline-block align-top" id="image">
                  Bootstrap
                </a>
              </div>
            </nav>
            <div class="card">
                <img src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Bootstrap_logo.svg" alt="" width="100" height="100" class="d-inline-block align-top" id="image">
                <form action="NewServlet3" method ="get">
                    <label for="fuser" class="form-label">Usuário:</label>
                    <input type="text" id="fuser" name="fuser" class="form-control"><br><br>

                    <label for="lpassword" class="form-label">Senha:</label>
                    <input type="text" id="lpassword" name="lpassword" class="form-control"><br><br>

                    <input type="submit" name="operacao" value="Login" class="btn btn-primary" id="buttonForm">
                </form>
            </div>
        </div>
        <% if(mensagem == "TRUE") { %>
            <div class="alert alert-primary" role="alert" data-bs-dismiss="alert">
                Usuário ou senha incorretos !
            </div>
        <% } %>
    </body>
</html>

<style>
    body {
        background-color: #F0FFFF;
    }
    
    form {
        margin: 20px;
    }
    
    label {
        font-weight: 500;
        color: #8A2BE2;
        margin-left: 70px;
    }
    
    .container-fluid {
        background-color: #8A2BE2;        
    }
    
    .alert {
        margin-top: 285px;
    }
    
    .alert-primary {
        display: flex;
        justify-content: center;
    }
    
    #image {
        margin-top: 4px;
    }
    
    #anchor {
        color: white;
    }
    
    #buttonForm {
        background-color: #8A2BE2;
        margin-left: 60px;
    }
    
    .card {
        margin: 0 auto;
        margin-top: 250px;
        width: 25%;
        background-color: #F0F8FF;
        border-radius: 5px;
        align-items: center;
        display: flex;
        justify-content: center;
    }
    
    .message {
        display: flex;
        justify-content: center;
    }
</style>

<script>
    var alertList = document.querySelectorAll('.alert')
    alertList.forEach(function (alert) {
      new bootstrap.Alert(alert)
})
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
