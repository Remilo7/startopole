<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zarządzanie galeriami zdjęć</title>

    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" />" rel="stylesheet">
    <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/subpage.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/gallery.css" />" rel="stylesheet">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50" onresize="stickyUpdate()">

<a href="index">
    <div class="container-fluid" id="bg_div">
        <div class="row">
            <div class="col-md-12 no-padding"></div>
        </div>
    </div>
</a>

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
                        <li><a href="index#section1">Aktualności</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">O klubie<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="index#section2">Historia</a></li>
                                <li><a href="coaches">Kadra trenerska</a></li>
                                <li><a href="members">Zawodnicy</a></li>
                            </ul>
                        </li>
                        <li><a href="index#section3">Treningi</a></li>
                        <li class="active"><a href="index#section4">Galeria</a></li>
                        <li><a href="index#section5">Kontakt</a></li>
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

<div class="user_panel container-fluid no-padding">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8 text-center">
            <h1 class="news">${gallery.name}</h1>

            <article class='gallery'>
                <c:forEach begin="0" end="${gallery.amount-1}" varStatus="loop">
                    <a class='gallery-link' href='<c:url value="${'/resources/uploaded/galleries/gallery'.concat(gallery.id).concat('/img_').concat(loop.index).concat('.jpg')}" />'>
                        <figure class='gallery-image'>
                            <img src='<c:url value="${'/resources/uploaded/galleries/gallery'.concat(gallery.id).concat('/img_').concat(loop.index).concat('.jpg')}" />'>
                        </figure>
                    </a>
                </c:forEach>
            </article>

        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/affix.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/gallery.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/gallery-2.js" />"> </script>

<!-- Navbar Affix -->
<script type="text/javascript">
    window.onscroll = function() {myFunction()};
</script>

</body>
</html>
