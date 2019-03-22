<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Rejestracja</title>

    <link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/subpage.css" />" rel="stylesheet">
</head>
<body>

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
                        <li><a href="index#section1">Aktualności</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">O klubie<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="index#section2">Historia</a></li>
                                <li><a href="index#">Kadra trenerska</a></li>
                                <li><a href="index#">Zawodnicy</a></li>
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

<div class="container col-sm-12">
    <div class="col-md-4"></div>
    <div class="card col-md-4">
        <div class="card-header">
            <h3>Rejestracja</h3>
        </div>
        <div class="card-body">
            <form>
                <div class="form-group">
                    <input type="email" class="form-control" name="reg_email" placeholder="Adres e-mail">
                    <input type="text" class="form-control" name="reg_name"placeholder="Imię">
                    <input type="text" class="form-control" name="reg_surname" placeholder="Nazwisko">
                    <input type="date" class="form-control" name ="reg_date" placeholder="Data urodzenia">
                    <input type="text" class="form-control" name="reg_surname" placeholder="Nazwisko">
                    <input type="text" class="form-control" name="reg_pesel" placeholder="Numer pesel">
                    <input type="text" class="form-control" name="reg_address" placeholder="Adres">
                    <input type="tel" class="form-control" name="reg_phone" pattern="^[2-9]\d{2}-\d{3}-\d{3}$" placeholder="Telefon kontaktowy">
                </div>

                <div class="text-center">
                    <input type="submit" value="Zarejestruj" class="btn login_btn form-control">
                </div>
            </form>
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

<!-- Navbar Affix -->
<script type="text/javascript">
    $('#nav').affix({
        offset: {
            top: $('#bg_div').height()
        }
    });
</script>

</body>
</html>
