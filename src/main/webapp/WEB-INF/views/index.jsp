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

    <div class="container-full">

        <div id="section0" class="container-fluid"></div>
        <div id="section1" class="container-fluid">

            <h1>Aktualności</h1>

            <div class="row">
                <div class="col-xs-6 col-md-3">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/static/img/news.jpg" />" alt="News 1">
                        <div class="caption">
                            <p>Etizzle shiznit fo shizzle sizzle augue hendrerizzle accumsizzle. Gizzle izzle est. Vivamizzle hizzle dolor, sure vitae, yippiyo id, ultrices izzle, sheezy.</p>
                            <p><a href="#" class="btn btn-primary" role="button">Więcej</a></p>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-md-3">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/static/img/news.jpg" />" alt="News 2">
                        <div class="caption">
                            <p>Etizzle shiznit fo shizzle sizzle augue hendrerizzle accumsizzle. Gizzle izzle est. Vivamizzle hizzle dolor, sure vitae, yippiyo id, ultrices izzle, sheezy.</p>
                            <p><a href="#" class="btn btn-primary" role="button">Więcej</a></p>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-md-3">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/static/img/news.jpg" />" alt="News 3">
                        <div class="caption">
                            <p>Etizzle shiznit fo shizzle sizzle augue hendrerizzle accumsizzle. Gizzle izzle est. Vivamizzle hizzle dolor, sure vitae, yippiyo id, ultrices izzle, sheezy.</p>
                            <p><a href="#" class="btn btn-primary" role="button">Więcej</a></p>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-md-3">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/static/img/news.jpg" />" alt="News 4">
                        <div class="caption">
                            <p>Etizzle shiznit fo shizzle sizzle augue hendrerizzle accumsizzle. Gizzle izzle est. Vivamizzle hizzle dolor, sure vitae, yippiyo id, ultrices izzle, sheezy.</p>
                            <p><a href="#" class="btn btn-primary" role="button">Więcej</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <p><a href="#" class="btn btn-primary" role="button">Poprzednie wpisy</a></p>
            </div>
        </div>

        <div id="section2" class="container-fluid">

            <h1>O klubie</h1>

            <p>Początki szermierki na Opolszczyźnie sięgają września 1950 r., kiedy to w Spójni Opole treningi z młodzieżą rozpoczął fechmistrz Wirgiliusz Kuleczko.
                Wkrótce ćwiczyło już 26 zawodników, co pozwoliło dwa lata później na rozegranie pierwszych mistrzostw województwa opolskiego.</p>

            <p>W 1953 r. po raz pierwszy w Opolu zorganizowano imprezę mistrzowską – Mistrzostwa Polski w florecie drużynowym kobiet i mężczyzn.
                Zawody rozgrywano w hali Budowlanych. Jako pierwsze rozpoczęły kobiety. Turniej był bardzo emocjonujący, a losy tytułu ważyły się do ostatniej walki w finale. O tytuł mistrza wśród mężczyzn rywalizowało 12 zespołów. Na najwyższym poziomie stało spotkanie CWKS - Budowlani decydujące o tytule mistrzowskim.</p>

            <p>Mecz toczył się w atmosferze zaciętej walki o każde trafienie i trwał ponad dwie i pół godziny!</p>

            <p>Po raz drugi mistrzostwa Polski w Opolu odbywały się w 1958 r.</p>

            <p>Znów były to zawody drużynowe we florecie. Walka o tytuły trwała przez całe mistrzostwa. Wśród kobiet liczyły się dwie pierwsze drużyny, które wysoko wygrywały wszystkie pojedynki.
                Dopiero bezpośrednie spotkanie wygrane przez zawodniczki z Katowic 12:4 zadecydowało o ich tytule, a pokonane warszawianki musiały zadowolić się srebrnym medalem.</p>

            <p>Wśród mężczyzn rywalizacja była znaczniej bardzie wyrównana. Faworytami byli mistrzowie sprzed roku Legia Warszawa.
                Jednak w drugim dniu zmagań zespół Marymontu pokonał Legię 9:7, a po wygranej w ostatnim dniu z Kolejarzem Wrocław 9:5 zapewnił sobie tytuł mistrzowski.
                Marymont przegrał tylko jeden mecz z GKS Gliwice 6:10.</p>

            <p>W tym czasie na terenie województwa opolskiego działało już kilka klubów z sekcjami szermierczymi: LPŻ Opole, MKS Patria MDK Opole, MKS Sławęcice, Polonia Nysa, Zawisza Otmęt, które rozgrywały regularnie rozgrywki ligowe o mistrzostwo województwa.
                W dniu 14 marca 1962 r., z inicjatywy trenera Czesława Wojciechowskiego powstaje sekcja szermiercza przy SKS Start po fuzji z MKS Patria.</p>

            <p>Pracą szkoleniową w tym Klubie w okresie jej istnienia oprócz Czesława Wojciechowskiego zajmowali się; Bogusław Kubicki – trener vice Mistrza Świata w szabli aktualnego Prezesa PZSZ Jacka Bierkowskiego, Jerzy Kłosowicz, Ryszard Marszałek oraz Ryszard Chocki i Marek Czajkowski.
                Pochodzący z Opola trenerzy Ruta Gołąbek-Osyczka oraz Jacek Syczka kontynuowali trenerską karierę w Niemczech, gdzie piastowali funkcje trenerów kadry narodowej we florecie kobiet i szabli.</p>

            <p>Apogeum sukcesów opolskiej szermierki przypada na przełom lat siedemdziesiątych i osiemdziesiątych XX wieku za sprawą Piotra Jabłkowskiego – zawodnika Startu (wychowanek trenera Czesława Wojciechowskiego), który wywalczył srebrny medal na Igrzyskach Olimpijskich w 1980 r. w szpadzie drużynowej.
                Wcześniej, w 1978 r. w Madrycie Jabłkowski wywalczył brąz w mistrzostwach świata juniorów oraz zajął czwarte miejsce w mistrzostwach świata wśród seniorów. Zwłaszcza to drugie wydarzenie przeszło do historii opolskiej szermierki: zawodnik z Opola w finale uniemożliwiał swojemu przeciwnikowi zadanie trafienia,
                które dawałoby Jabłkowskiemu srebrny medal, a jego przeciwnikowi złoty i w efekcie opolanin zamiast medalu zakończył zawody na czwartym miejscu, za co został później wyróżniony nagrodą fair-play.</p>

            <p>Z biegiem czasu szermierka w Opolu uprawiana w coraz mniejszej ilości klubów, w końcu tylko w Starcie i Zrywie, potem w UKS Piątka trenera Zbigniewa Borysiuka.
                W 2002 r. po powrocie do Opola trenera Czesława Wojciechowskiego doprowadził on wraz z małżonką Mariolą do reaktywacji Startu jako klubu uczniowskiego i obecnie w Opolu szermierze mogą reprezentować barwy dwóch klubów: Uczniowskiego Klubu Sportowego „Start” i Akademickiego Klubu Szermierczego.</p>

            </div>
        </div>

        <div id="section3" class="container-fluid">
            <h1>Treningi</h1>
            <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
            <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        </div>

        <div id="section4" class="container-fluid">
            <h1>Galeria</h1>
            <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
            <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        </div>

        <div id="section5" class="container-fluid">
            <h1>Kontakt</h1>
            <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
            <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
        </div>
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
