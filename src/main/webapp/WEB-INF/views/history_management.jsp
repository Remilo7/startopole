<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zarządzanie sekcją - historia klubu</title>

    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/subpage.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/buttons.css" />" rel="stylesheet">
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
                        <li><a href="index#section4">Galeria</a></li>
                        <li><a href="index#section5">Kontakt</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
                        <li class="active"><a href="adminPanel">Panel</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>

<!-- Treść strony -->

<div class="user_panel container-fluid no-padding">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 text-center">
            <h1>Zarządzaj akapitami w sekcji - historia klubu</h1>
        </div>
    </div>
    <form:form action="history.do" method="post" modelAttribute="section">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 panel_window">

                <table class="table table-hover table-responsive">
                    <thead>
                    <tr>
                        <th />
                        <th>Nagłówek akapitu</th>
                        <th>Początek akapitu</th>
                    </tr>
                    </thead>

                    <c:forEach items="${sectionList}" var="section">
                        <tbody>
                        <tr>
                            <td><form:radiobutton cssClass="formradio" path="id" value="${section.id}"/></td>
                            <td>${section.header}</td>
                            <td><xmp>${fn:substring(section.content,0,50).concat("...")}</xmp></td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>

            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 no-padding text-center">
                <div class="col-xs-6 col-md-3 newsButtons">
                    <button class="btn btn-navy btn-border" name="action" value="Back">Wstecz</button>
                </div>
                <div class="col-xs-6 col-md-3 newsButtons">
                    <button class="btn btn-red btn-border" type="submit" name="action" value="Delete">Usuń</button>
                </div>
                <div class="col-xs-6 col-md-3 newsButtons">
                    <button class="btn btn-blue btn-border" name="action" value="Rededit">Edytuj</button>
                </div>
                <div class="col-xs-6 col-md-3 newsButtons">
                    <button class="btn btn-green btn-border" name="action" value="Redirect">Dodaj</button>
                </div>
            </div>
        </div>
    </form:form>
</div>

<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/affix.js" />"> </script>

<!-- Navbar Affix -->
<script type="text/javascript">
    window.onscroll = function() {myFunction()};
</script>

</body>
</html>
