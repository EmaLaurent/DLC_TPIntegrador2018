<%-- 
    Document   : busqueda
    Created on : 19/04/2018, 20:56:47
    Author     : Emanuel Laurent
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="icon" href="Imagenes/icono.jpg">
        <title>Resultados de Búsqueda</title>
    
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Css de ésta página -->
        <link href="<c:url value="/css/search.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body class="text-center">
        <div class="container-fluid d-flex flex-column p-3">
            <div class="row">
            <div class="d-flex justify-content-between col-12">
                <div class="p-2">
                    <h3 class="masthead-brand">Excelsior! Search</h3>
                </div>
                <div class="p-2 col-4">
                    <img src="Imagenes/Excelsior03.png" class="col-12">
                </div>
                <div class="p-2">
                    <nav class="nav nav-masthead justify-content-center">
                    <a class="nav-link" href="/DLC_TPIntegrador2018">Inicio</a>
                    <a class="nav-link" href="#">Características</a>
                    <a class="nav-link" href="#">Contacto</a>
                    </nav>
                </div>
            </div>
            </div>
            <div class="row p-3">
               <div class="col-6">
                    <form accept-charset="ISO-8859-1" id="search_form" method="post" action="<c:url value="/search"/>">
                        <input type="text" name="buscar_txt" id="buscar_txt" class="col-10">
                        <input type="submit" class="btn btn-secondary" value="Buscar">
                    </form>
                </div> 
            </div>
            <h3>Resultados de Búsqueda para : ${busqueda}</h3>
            <hr width="80%" style="background: gray">
            <c:forEach items="${resultados}" var="resultado">
                <div class="row docInfo p-1">
                    <div class="card bg-dark border-light col-7 offset-1">
                        <div class="card-header">
                            <a class="h5" href="file:///${resultado.doc.path}">${resultado.doc.titulo}</a>
                        </div>
                        <div class="text-light">
                            <h6 class="mb-2 text-warning">${resultado.doc.nombArchivo}</h6>
                            <p class="card-text">${resultado.doc.intro}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <nav aria-label="Páginas de resultados de búsqueda">
                <ul class="pagination p-2 mb-0 justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
            <hr width="80%" style="background: gray">
            <footer class="mastfoot mt-auto">
                <div class="inner">
                    <p>©Copyrigth 2018 <a href="https://getbootstrap.com/">UTN Solutions</a>, by <a href="https://www.instagram.com/emaalaurent/">@emaalaurent</a>.</p>
                </div>
            </footer>
        </div>
            
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="<c:url value="/js/jquery-3.3.1.slim.min.js"/>" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="<c:url value="/js/popper.min.js"/>" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <script src="<c:url value="/js/boostrap.min.js"/>" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    </body>
</html>
