<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Matacu�s</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/animatecss/2.1.0/animate.min.css">
    <link rel="stylesheet" href="http://openlayers.org/en/v3.2.0/css/ol.css" type="text/css"> 
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.0/css/bootstrap-toggle.min.css" rel="stylesheet">

    <link rel="stylesheet" href="stylesheet/sidebar.css">
    <link rel="stylesheet" href="stylesheet/single.css">

    <!-- Custom styles for this template -->

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="navbar navbar-inverse navbar-fixed-top navbar-custom">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle toggle-left hidden-lg" data-toggle="sidebar" data-target=".sidebar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" onclick="principal()">Matacuas</a>
          <ul class="nav navbar-nav navbar-right navRight">
            <li onclick="settings()"><span class="glyphicon glyphicon-cog cogGly"></span>  </li>
          </ul>
        </div>
      </div>



    </div>

    <div class="navbar navbar-inverse navbar-fixed-bottom menuB" >

      <div class="row">
       <div class="col-xs-4 text-center">
        <a onclick="newQueja(0)">
          <span class="
          glyphicon glyphicon-thumbs-down glyM"></span>
          <p>Negativa</p></a>
        </div>
        <div class="col-xs-4 text-center">
          <a onclick="newQueja(1)">
            <span style="font-size:2.5em" class="
            glyphicon glyphicon-camera glyM"></span>
          </a>
        </div>

        <div class="col-xs-4 text-center">
          <a onclick="newQueja(2)">
            <span class="
            glyphicon glyphicon-thumbs-up glyM"></span>
            <p>Positiva</p></a>
          </div>

        </div>

      </div>


      <div class="container">
        <div class="row">
          <div class="col-xs-7 col-sm-3 col-md-2 sidebar sidebar-left sidebar-animate sidebar-lg-show ">
            <div class="menuHead">
              <div class="row">
                <div class="col-xs-8 col-xs-offset-2 col-md-12 col-md-offset-0" onclick="profile()">
                    <img src="https://randomuser.me/api/portraits/med/men/44.jpg" alt="" class="img img-responsive imgTarjeta img-circle" >
                </div>
              </div>        
            </div>

            <ul class="nav navbar-stacked">
              <li><br></li>
               <li><br></li>
                <li><br></li>
                <li onclick="profile()"><a href="#">Perfil</a></li>
              <li onclick="notification()"><a href="#">Notificaciones <Span class="badge">2</Span></a></li>
              <li onclick="principal()"><a href="#">Entorno</a></li>
            </ul>
          </div>

          <div class="main col-md-9 col-md-offset-3">
            
            <!--aqui el contenido-->
              <div id="payLoadSP">
              
              </div>
            <!--acaba el contenido --> 
          </div>
        </div>
      </div>
      <!-- /.container -->

  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <script src="js/sidebar.js"></script>
     <script type='text/javascript' src="js/OpenLayers.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js"></script>
      <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>
 <script src="js/mapa.js"></script>

  <script src="js/main.js?v=38"></script>
  <script>
     $( document ).ready(principal())
  </script>
</body>
</html>