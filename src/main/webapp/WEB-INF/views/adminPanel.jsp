<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Panel administratora</title>

    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/subpage.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/calendar.css" />" rel="stylesheet">
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
        <div class="col-md-7">
            <h1>${admin_name}</h1>
        </div>
        <div class="col-md-5"></div>
    </div>

    <div class="row">

        <div class="col-md-7 panel_window">
            <ul class="nav nav-tabs">
                <li><a data-toggle="tab" href="#menu1">Wysłane wiadomości</a></li>
                <li><a data-toggle="tab" href="#menu2">Lista zawodników</a></li>
                <li class="active"><a data-toggle="tab" href="#sections">Zarządzaj sekcjami</a></li>
                <li><a href="events_management">Wydarzenia</a></li>
            </ul>

            <div class="tab-content">

                <div id="menu1" class="tab-pane fade">

                    <form:form action="messages.do" method="post" modelAttribute="message">
                        <table class="table table-hover table-responsive">
                            <thead>
                            <tr>
                                <th />
                                <th>Odbiorca</th>
                                <th>Kategoria</th>
                                <th>Treść</th>
                                <th>Data wysłania</th>
                            </tr>
                            </thead>

                            <c:forEach items="${sentMessages}" var="message">
                                <tbody>
                                <tr>
                                    <td><form:radiobutton path="id" value="${message.id}"/></td>
                                    <td>${message.receiver}</td>
                                    <td>${message.category}</td>
                                    <td>${message.content}</td>
                                    <td>${message.added_date}</td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>

                        <button class="btn btn-red btn-border pull-left" name="action" value="deleteMessage">Usuń</button>
                    </form:form>

                </div>

                <div id="menu2" class="tab-pane fade">

                    <form:form action="fencers.do" method="post" modelAttribute="fencer">
                        <table class="table table-hover table-responsive">
                            <thead>
                            <tr>
                                <th />
                                <th>Imię</th>
                                <th>Nazwisko</th>
                            </tr>
                            </thead>

                            <c:forEach items="${fencerList}" var="fencer">
                                <tbody>
                                <tr>
                                    <td><form:checkbox path="usernameList" value="${fencer.username}"/></td>
                                    <td>${fencer.name}</td>
                                    <td>${fencer.surname}</td>
                                </tr>
                                </tbody>
                            </c:forEach>
                        </table>

                        <button class="btn btn-blue btn-border pull-left" name="action" value="sendMessage">Wyślij wiadomość</button>
                        <button class="btn btn-green btn-border pull-right" name="action" value="showData">Wyświetl dane</button>
                    </form:form>
                </div>

                <div id="sections" class="tab-pane fade in active">
                    <div class="row">
                        <div class="col-md-6 text-center">
                            <a href="articles_management"><button class="button">Aktualności</button></a>
                            <br>
                            <a href="galleries_management"><button class="button">Galeria</button></a>
                            <br>
                            <a href="trainings_management"><button class="button">Treningi</button></a>
                            <br>
                            <a href="contact_management"><button class="button">Kontakt</button></a>
                        </div>
                        <div class="col-md-6 text-center">
                            <a href="coaches_management"><button class="button">Kadra trenerska</button></a>
                            <br>
                            <a href="members_management"><button class="button">Zawodnicy</button></a>
                            <br>
                            <a href="history_management"><button class="button">Historia</button></a>
                            <br>
                            <a href="users_management"><button class="button">Użytkownicy</button></a>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="col-md-5">
            <div id="calendar"></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.5.1/moment.min.js" />"> </script>

<!-- Kalendarz -->
<script>
    var data = [];

    <c:forEach items="${eventList}" var="event">
        data.push({eventName: '${event.eventName}', calendar: '${event.calendar}', color: '${event.color}', date: '${event.date}'});
    </c:forEach>
</script>

<script type="text/javascript" src="<c:url value="/resources/static/js/calendar.js" />"> </script>

<script type="text/javascript" src="<c:url value="/resources/static/js/affix.js" />"> </script>

<!-- Navbar Affix -->
<script type="text/javascript">
    window.onscroll = function() {myFunction()};
</script>

</body>
</html>
