<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zarządzanie użytkownikami</title>

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

<div class="user_panel container-fluid">

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 text-center">
            <h1>Zarządzaj użytkownikami</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>

        <div class="col-md-6 panel_window">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#notactive">Nieaktywni użytkownicy</a></li>
                <li><a data-toggle="tab" href="#active">Aktywni użytkownicy</a></li>
            </ul>

            <div class="tab-content">
                <div id="notactive" class="tab-pane fade in active">
                    <form:form action="users.do" method="post" modelAttribute="user">
                        <table class="table table-hover table-responsive">
                            <thead>
                                <tr>
                                    <th />
                                    <th>Nazwa użytkownika</th>
                                    <th>Imię</th>
                                    <th>Nazwisko</th>
                                </tr>
                            </thead>

                            <c:forEach items="${notactives}" var="user">
                                <tbody>
                                    <tr>
                                        <td><form:radiobutton path="username" value="${user.username}"/></td>
                                        <td>${user.username}</td>
                                        <td>${user.name}</td>
                                        <td>${user.surname}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>

                        <button class="btn btn-navy btn-border pull-left" name="action" value="Back">Wstecz</button></a>
                        <button class="btn btn-green btn-border pull-right" name="action" value="activate">Aktywuj</button>
                    </form:form>
                </div>

                <div id="active" class="tab-pane fade">
                    <form:form action="users.do" method="post" modelAttribute="user">
                        <table class="table table-hover table-responsive">
                            <thead>
                                <tr>
                                    <th />
                                    <th>Nazwa użytkownika</th>
                                    <th>Imię</th>
                                    <th>Nazwisko</th>
                                </tr>
                            </thead>

                            <c:forEach items="${actives}" var="user">
                                <tbody>
                                <tr>
                                    <td><form:radiobutton path="username" value="${user.username}"/></td>
                                    <td>${user.username}</td>
                                    <td>${user.name}</td>
                                    <td>${user.surname}</td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>

                        <button class="btn btn-navy btn-border pull-left" name="action" value="Back">Wstecz</button></a>
                        <button class="btn btn-red btn-border pull-right" name="action" value="deactivate">Dezaktywuj</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
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
