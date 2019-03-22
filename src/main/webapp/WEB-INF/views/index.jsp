<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Strona Główna</title>
        
        <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" />" rel="stylesheet">
        <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="50">

    <div class="container-fluid" id="bg_div">
        <div class="row">
            <div class="col-md-12 no-padding"></div>
        </div>
    </div>

    <div id="nav">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-center">
                            <li><a href="#section1">Aktualności</a></li>
                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">O klubie<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#section2">Historia</a></li>
                                    <li><a href="#">Kadra trenerska</a></li>
                                    <li><a href="#">Zawodnicy</a></li>
                                </ul>
                            </li>
                            <li><a href="#section3">Treningi</a></li>
                            <li><a href="#section4">Galeria</a></li>
                            <li><a href="#section5">Kontakt</a></li>
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </div>

    <div id="section0" class="container-fluid"></div>
    <div id="section1" class="container-fluid">
        <h1>Section 1</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>
    <div id="section2" class="container-fluid">
        <h1>Section 2</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>
    <div id="section3" class="container-fluid">
        <h1>Section 3</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>
    <div id="section4" class="container-fluid">
        <h1>Section 4</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>
    <div id="section5" class="container-fluid">
        <h1>Section 5</h1>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
    </div>

    <script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"> </script>
    <script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"> </script>

    <!-- Navbar Affix -->
    <script type="text/javascript">
        $('#nav').affix({
            offset: {
                top: $('#bg_div').height()
            }
        });
    </script>

    <!-- Smooth Scroll -->
    <script type="text/javascript">
        $("#nav ul li a[href^='#']").on('click', function(e) {
            e.preventDefault();

            var hash = this.hash;

            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 300, function(){
                window.location.hash = hash;
            });
        });
    </script>

    </body>
</html>
