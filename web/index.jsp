<%-- 
    Document   : index
    Created on : 18/04/2018, 16:28:20
    Author     : Emanuel Laurent
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="icon" href="Imagenes/icono.jpg">
        <title>Excelsior!</title>
    
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Css de ésta página -->
        <link href="<c:url value="/css/cover.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body class="text-center">
        <div class="d-flex h-100 p-3 mx-auto flex-column">
            <header class="masthead">
                <div class="inner">
                    <h3 class="masthead-brand">Excelsior! Search</h3>
                    <nav class="nav nav-masthead justify-content-center">
                    <a class="nav-link active" href="#">Inicio</a>
                    <a class="nav-link" href="#">Características</a>
                    <a class="nav-link" href="#">Contacto</a>
                    </nav>
                </div>
            </header>
            <div class="container">
            <div class="row justify-content-between">
                <div class="col-2">
                    <button type="button" id="indexar_btn" class="btn btn-outline-danger" >Indexar</button>
                </div>
                <div class="col-4">
                    <label class="badge badge-pill badge-danger">Cantidad de palabras indexadas: ${cantPalabras}</label>
                </div>
            </div>
            </div>
            <div class="col-sm-2"></div>
            <form accept-charset="ISO-8859-1" id="search_form" method="post" action="<c:url value="/search"/>">
                <main role="main" class="inner cover">
                    <img src="Imagenes/Excelsior.png" style="width: 700px">
                    <h3>Todo lo que necesitás, en un solo lugar.</h3>
                    <p class="lead">
                        <input type="text" name="buscar_txt" id="buscar_txt">
                        <input type="submit" class="btn btn-lg btn-secondary" value="Buscar">
                    </p>
                </main>
            </form>

            <footer class="mastfoot mt-auto">
                <div class="inner">
                    <p>©Copyrigth 2018 <a href="https://getbootstrap.com/">UTN Solutions</a>, by <a href="https://www.instagram.com/emaalaurent/">@emaalaurent</a>.</p>
                </div>
            </footer>
        </div>
        <script type="text/javascript">
            function indexar() 
            {
                window.location = "<c:url value="/indexar"/>";
            }
            document.getElementById("indexar_btn").onclick = indexar;
        </script>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="<c:url value="/js/jquery-3.3.1.slim.min.js"/>" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="<c:url value="/js/popper.min.js"/>" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <script src="<c:url value="/js/boostrap.min.js"/>" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    </body>
</html>
