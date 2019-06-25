<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Rejestracja</title>

    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/subpage.css" />" rel="stylesheet">
</head>
<body onresize="stickyUpdate()">

<!-- Menu strony -->

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
                        <li class="active"><a href="login"><span class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>

<!-- Treść strony -->

<div class="container col-sm-12">
    <div class="col-md-4"></div>
    <div class="card col-md-4">

        <div class="card-header">
            <h3>Rejestracja</h3>
        </div>

        <!-- /registration?error=true -->
        <c:if test="${param.error == 'true'}">
            <div style="color:red;margin:10px 0px;">
                Użytkownik o podanej nazwie istnieje już w bazie
            </div>
        </c:if>

        <div class="card-body">
            <form:form action="addUser" method="post" modelAttribute="registrationviewmodel">
                <div class="form-group">
                    <form:input type="text" path="userName" class="form-control" placeholder="Nazwa użytkownika" required="required" />
                    <form:input type="email" path="email" class="form-control" placeholder="Adres e-mail" required="required" />
                    <form:input type="password" path="password" class="form-control" placeholder="Hasło" required="required" />
                    <form:input type="text" class="form-control" path="name" placeholder="Imię" required="required" />
                    <form:input type="text" class="form-control" path="surname" placeholder="Nazwisko" required="required" />
                    <form:input type="date" class="form-control" path="bir_date" placeholder="Data urodzenia: DD.MM.RRRR" required="required" />
                    <form:input type="tel" class="form-control" path="phone" pattern="^[2-9]\d{2}-\d{3}-\d{3}$" maxlength="11" placeholder="Telefon kontaktowy" required="required" id="txtnumber" />
                </div>

                <div class="text-center">
                    <button value="Zarejestruj" class="btn login_btn form-control" name="action">Zarejestruj</button>
                </div>
            </form:form>
        </div>
        <div class="card-footer">
            <div class="d-flex justify-content-center links">
                Posiadasz już konto?<a href="login">Zaloguj się</a>
            </div>
        </div>
    </div>
    <div class="col-md-4"></div>
</div>

<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/static/js/affix.js" />"> </script>

<!-- Navbar Affix -->
<script type="text/javascript">
    window.onscroll = function() {myFunction()};
</script>

<!-- Automatyczne dodawanie myślników w numerze telefonu -->
<script type="text/javascript">
    $(function () {

        $('#txtnumber').keydown(function (e) {
            var key = e.charCode || e.keyCode || 0;
            $text = $(this);
            if (key !== 8 && key !== 9) {
                if ($text.val().length === 3) {
                    $text.val($text.val() + '-');
                }
                if ($text.val().length === 7) {
                    $text.val($text.val() + '-');
                }

            }

            return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
        })
    });
</script>

</body>
</html>
