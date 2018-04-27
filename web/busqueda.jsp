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
    <link href="<c:url value="/css/cover.css"/>" rel="stylesheet" type="text/css" />
  </head>
  <body class="text-center">
    <div class="d-flex h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">Excelsior! Search</h3>
      </header>

        <h2>Resultados de Búsqueda para : ${busqueda}</h2>
        <hr width="80%" style="background: gray">
        <h4>Todavía no hay nada wacho!!</h4>
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
