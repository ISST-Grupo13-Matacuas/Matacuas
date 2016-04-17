<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Matacuás</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/animatecss/2.1.0/animate.min.css">
    <link rel="stylesheet" href="http://openlayers.org/en/v3.2.0/css/ol.css" type="text/css"> 
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.0/css/bootstrap-toggle.min.css" rel="stylesheet">

    <link rel="stylesheet" href="stylesheet/sidebar.css">
    <link rel="stylesheet" href="stylesheet/single.css">

    <!-- Custom styles for this template -->
 <style>
  body{
    background: #CCB;
  }
  .card {
            background: #fff;
            border-radius: 2px;
            display: block;
            float: left;
            /*height: 300px;*/
            margin: 1rem;
            position: relative;
            /*width: 300px;*/
        }

        .card-1 {
            box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
            transition: all 0.2s ease-in-out;
        }

        .card-1:hover {
            box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
        }


</style> 
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  

  <body>

<div class="container">
    <div class="col-xs-12 col-sm-3 card card-2 text-center">
      <h1>Filtros</h1>
      <hr>

      <form action="/ConsultaAseguradora" method="get">
 <h3>Matrícula:</h3>
  <input type="matricula" class="form-control" id="matricula" name="matricula" placeholder="${matricula}" ><br>
  <input type="submit" value="Consultar" class="btn">
</form>
<br>
<br>
<hr>
<br>
<a href="/">Volver a la app</a>
      
      <br>
      <br>
    </div>
    <div class="col-xs-12 col-sm-8 col-sm-offset-1 card card-2">
      <div class="row">
      <div class="col-xs-12 text-center">
          <h3>Ha buscado por matrícula: ${matricula} </h3>
          <hr>
      </div>

      <div class="col-xs-12 text-center">
          <br><br>
          <p>El vehiculo consultado tienes ${numQuejas} quejas y ${numFelicitaciones} felicitaciones</p>
          <p>Su balance es de: ${balance}</p>
  <br><br>
      </div>

      </div>

    </div>

  </div>
  
  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <script src="js/sidebar.js"></script>>
  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>
</body>
</html>