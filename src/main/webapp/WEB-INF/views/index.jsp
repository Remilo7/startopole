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
        <link href="<c:url value="/resources/static/css/index_style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/static/css/buttons.css" />" rel="stylesheet">
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="50" onresize="stickyUpdate()">

    <!-- Menu strony -->

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
                                    <li><a href="coaches">Kadra trenerska</a></li>
                                    <li><a href="members">Zawodnicy</a></li>
                                </ul>
                            </li>
                            <li><a href="#section3">Treningi</a></li>
                            <li><a href="#section4">Galeria</a></li>
                            <li><a href="#section5">Kontakt</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Wyloguj się</a></li>
                                <li><a href="panel">Panel</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </div>

    <!-- Treść strony -->

    <div id="section0" class="container-fluid"></div>
    <div id="section1" class="container-fluid">

        <h1>Aktualności</h1>
        <br>
        <div class="row display-flex">

            <c:forEach begin="0" end="3" items="${articleList}" var="article">

                <div class="col-xs-6 col-md-3 thumbMargin">
                    <div class="thumbnail">
                        <img src="<c:url value="${'/resources/uploaded/img_'.concat(article.id).concat('.jpg')}" />" alt="image">
                        <div class="caption">
                            <a href="articles">${article.title}</a>
                        </div>
                    </div>
                </div>

            </c:forEach>

        </div>
        <div class="text-center">
            <p><a href="articles" class="btn btn-blue btn-border" role="button">Czytaj dalej</a></p>
        </div>
    </div>

    <div id="section2" class="container-fluid">

        <h1>O klubie</h1>
        <br>

        <c:forEach items="${historySectionList}" var="section">
            <h3>${section.header}</h3>
            <p>${section.content}</p>
        </c:forEach>

    </div>

    <div id="section3" class="container-fluid">
        <h1>Treningi</h1>
        <br>

        <c:forEach items="${trainingSectionList}" var="section">
            <h3 class="text-center">${section.header}</h3>
            <hr>
            <p class="text-center">${section.content}</p>
        </c:forEach>

    </div>

    <div id="section4" class="container-fluid">
        <h1>Galeria</h1>
        <br>
        <div class="row">

            <c:forEach begin="0" end="3" items="${galleryList}" var="gallery" varStatus="loop">

                <div class="col-xs-6 col-md-3">
                    <div class="thumbnail">
                        <img src="<c:url value="${'/resources/uploaded/galleries/gallery'.concat(gallery.id).concat('/img_').concat(loop.index).concat('.jpg')}" />" alt="image">
                        <div class="caption">
                            <a href="album?galleryId=${gallery.id}">${gallery.name}</a>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
        <div class="text-center">
            <p><a href="galleries" class="btn btn-blue btn-border" role="button">Więcej zdjęć</a></p>
        </div>
    </div>

    <div id="section5" class="container-fluid">
        <h1>Kontakt</h1>
        <br>

        <c:forEach items="${contactSectionList}" var="section">
            <h3 class="text-center">${section.header}</h3>
            <p class="text-center">${section.content}</p>
        </c:forEach>

    </div>

    <script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"> </script>
    <script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"> </script>
    <script type="text/javascript" src="<c:url value="/resources/static/js/affix.js" />"> </script>

    <!-- Navbar Affix -->
    <script type="text/javascript">
        window.onscroll = function() {myFunction()};
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
