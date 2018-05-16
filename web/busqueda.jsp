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
            <div class="row docInfo p-1">
                <div class="card bg-dark border-light col-7 offset-1">
                    <div class="card-header">
                        <a class="h5" href="https://es.wikipedia.org/wiki/El_Se%C3%B1or_de_los_Anillos">El Señor de los Anillos - Wikipedia, la enciclopedia libre</a>
                    </div>
                    <div class="text-light">
                        <h6 class="mb-2 text-warning">https://es.wikipedia.org/wiki/El_Señor_de_los_Anillos</h6>
                        <p class="card-text">El Señor de los Anillos (título original en inglés: The Lord of the Rings) es una novela de fantasía épica escrita por el filólogo y escritor británico J. R. R. Tolkien. Su historia se desarrolla en la Tercera Edad del Sol de la Tierra Media, un lugar ficticio poblado por hombres y otras razas antropomorfas como los hobbits, los ...</p>
                    </div>
                </div>
            </div>
            <div class="row docInfo p-1">
                <div class="card bg-dark border-light col-7 offset-1">
                    <div class="card-header">
                        <a class="h5" href="https://es.wikipedia.org/wiki/Trilog%C3%ADa_cinematogr%C3%A1fica_de_El_Se%C3%B1or_de_los_Anillos">Trilogía cinematográfica de El Señor de los Anillos - Wikipedia, la ...</a>
                    </div>
                    <div class="text-light">
                        <h6 class="mb-2 text-warning">https://es.wikipedia.org/wiki/Trilogía_cinematográfica_de_El_Señor_de_los_Anillos</h6>
                        <p class="card-text">La trilogía cinematográfica de El Señor de los Anillos, basada en la novela homónima del escritor británico J. R. R. Tolkien, comprende tres películas épicas de fantasía, acción y aventuras: El Señor de los Anillos: la Comunidad del Anillo (2001), El Señor de los Anillos: las dos torres (2002) y El Señor de los Anillos: el ...</p>
                    </div>
                </div>
            </div>
            <div class="row docInfo p-1">
                <div class="card bg-dark border-light col-7 offset-1">
                    <div class="card-header">
                        <a class="h5" href="https://www.infobae.com/america/entretenimiento/2018/04/08/la-serie-de-el-senor-de-los-anillos-tendra-cinco-temporadas-y-podria-costar-hasta-1-000-millones-de-dolares/">La serie de "El Señor de los Anillos" tendrá cinco temporadas y podría ...</a>
                    </div>
                    <div class="text-light">
                        <h6 class="mb-2 text-warning">https://www.infobae.com/america/entretenimiento/2018/04/08/la-serie-de-el-senor-de-los-anillos-tendra-cinco-temporadas-y-podria-costar-hasta-1-000-millones-de-dolares/</h6>
                        <p class="card-text">8 abr. 2018 - Amazon apunta alto con su nuevo proyecto. El gigante de comercio electrónico adquirió en noviembre del año pasado por USD 250 millones los derechos globales para explotar en televisión la obra de El Señor de los Anillos de J.R.R. Tolkien. La compañía de Jeff Bezos anunció a The Hollywood ...</p>
                    </div>
                </div>
            </div>
            <div class="row docInfo p-1">
                <div class="card bg-dark border-light col-7 offset-1">
                    <div class="card-header">
                        <a class="h5" href="https://es.wikipedia.org/wiki/El_Se%C3%B1or_de_los_Anillos:_la_Comunidad_del_Anillo">El Señor de los Anillos: la Comunidad del Anillo - Wikipedia, la ...</a>
                    </div>
                    <div class="text-light">
                        <h6 class="mb-2 text-warning">https://es.wikipedia.org/wiki/El_Señor_de_los_Anillos:_la_Comunidad_del_Anillo</h6>
                        <p class="card-text">El Señor de los Anillos: la Comunidad del Anillo (título original en inglés: The Lord of the Rings: The Fellowship of the Ring) es la primera película de la trilogía cinematográfica de El Señor de los Anillos, basada en el primer tomo de la novela homónima del escritor británico de literatura fantástica J. R. R. Tolkien; adaptado ...</p>
                    </div>
                </div>
            </div>
            <div class="row docInfo p-1">
                <div class="card bg-dark border-light col-7 offset-1">
                    <div class="card-header">
                        <a class="h5" href="http://es.ign.com/el-senor-de-los-anillos-1/130824/feature/los-10-mejores-personajes-de-el-senor-de-los-anillos">Los 10 mejores personajes de El Señor de los Anillos - IGN España</a>
                    </div>
                    <div class="text-light">
                        <h6 class="mb-2 text-warning">http://es.ign.com/el-senor-de-los-anillos-1/130824/feature/los-10-mejores-personajes-de-el-senor-de-los-anillos</h6>
                        <p class="card-text">18 mar. 2018 - El Señor de los Anillos no pasa de moda y sigue en auge y de actualidad. Estamos todavía algo atónitos por lo que se ha dado a conocer. Hemos sabido que se está preparando una ambiciosa serie para esta gran obra de J. R. R. Tolkien y que pronto podremos adelantar nuevos detalles. De momento ...</p>
                    </div>
                </div>
            </div>
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
