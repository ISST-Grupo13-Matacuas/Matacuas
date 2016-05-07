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
 @import url(https://fonts.googleapis.com/css?family=Rubik:400,300,400italic,500italic,500,700,700italic,300italic,900,900italic&subset=latin,latin-ext);
 
@import url(https://fonts.googleapis.com/css?family=Pacifico:400,300,400italic,500italic,500,700,700italic,300italic,900,900italic&subset=latin,latin-ext);
 

 body {

  background-attachment: fixed;
padding-top: 0px;
    padding-bottom: 0px;
    padding-top: 0px;
    overflow-x: hidden;
    font-family: rubik;
}

  .card {
            background: rgba(255,255,255,0.75);
            border-radius: 2px;
            display: block;
            float: left;
            /*margin: 1rem;*/
            position: relative;
        }

        .card-1 {
            box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
            transition: all 0.2s ease-in-out;
        }

        .card-1:hover {
            box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
        }
        #overLayer{
        	    height: 100%;
    width: 100%;
    position: fixed;
    background-color: rgba(59, 65, 97, 0.58);
    top: 0;
    z-index:0;
        }
        #principal{
        	 /*height: 100vh;*/
        	   width: 100%;
        	  /*background-color: rgba(250,250,250,0.9);*/
        	  z-index:9999;
        }
        
        #foot{
          height: 5vh;
    width: 100%;
    position: fixed;
    bottom: 0px;
    background-color: rgba(250,250,250,0.9);
    font-family: pacifico;
    padding-top: 1vh;
    color: rgba(191, 191, 191, 0.9);
        }
	
		.formMata{
		    height: 100px;
		    font-size: 2em;
		    /*border-radius: 2px;*/
		    /*border-style: solid;
		    border-color: #333;*/
		    text-align: center;
		    color: #629D9D;
		    /* box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);*/
            transition: all 0.2s ease-in-out;
                font-weight: bold;
    	}
    	#cajaFiltro{
    	    height: calc(100% - 15%);
    	    }
    	    #cajaInfo{
    	    height: 60vh;
    padding-left: 20px;
    }
    .btnMat{
    background-color: rgba(98,157,157,0.65);

        height: 2.3em;
    font-weight: bold;
    font-size: 1.5em;
    color: rgba(59, 65, 97, 0.58);
}
 .btnMat:hover{
     background-color: #629D9D;
     color: rgba(59, 65, 97, 0.58);
 }
    	
    hr{
    color: #629D9D;
    background-color: #629D9D;
    }
    #cajaInfoPL{
        padding-top: 11%;
    height: 100%;
    }
    .rowH{
    height: 100%
    }
    #tituloBar{
    margin-top:20px;
    margin-bottom: 20px;
    }
    .glyInv{
    	 transform: scaleX(-1);
            -moz-transform: scaleX(-1);
            -webkit-transform: scaleX(-1);
            -ms-transform: scaleX(-1);
    }

</style> 
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  

  <body>
  <div id="overLayer"></div>
<div class="container" id="principal">


<div class=" col-xs-12 card card-2 text-center" id="tituloBar">
	<h1>Consulta aseguradoras</h1>
       </div>
 <div class="col-xs-12 col-sm-3" id="cajaFiltro">
<div class=" row">
    <div class="col-xs-12 card card-2 text-center">
      <h1>Filtros</h1>
      <hr>

      <form action="/ConsultaAseguradora" method="get">
 <h3>Matrícula:</h3>
  <input type="matricula" class="form-control formMata" id="matricula" name="matricula" placeholder="${matricula}" ><br>
  <input type="submit" value="Consultar" class="btn btn-block btnMat">
</form>
<br>
<br>
<hr>
<br>
<a href="/"><span class="glyphicon glyphicon-share-alt glyInv"></span>Volver a la app </a>
      
      <br>
      <br>
    </div>
        </div>
         </div>
         
  <div class="col-xs-12 col-sm-9" id="cajaInfo">
<div class=" row rowH">
    <div class="col-xs-12 card card-2" id="cajaInfoPL">
      <div class="row">
      <div class="col-xs-12 text-center">
          <h3>Ha buscado por matrícula: ${matricula} </h3>
          <hr>
      </div>

      <div class="col-xs-12 text-center">
          <br><br>
          <p>El vehiculo consultado tiene ${numQuejas} queja<c:if test="${numQuejas != 1 }">s</c:if> y ${numFelicitaciones} felicitacion<c:if test="${numFelicitaciones != 1 }">es</c:if></p>
          <p>Su balance es de: ${balance}</p>
  <br><br>
      </div>

      </div>

    </div>
    </div>

    </div>
  </div>
  
  <div id="foot" class="text-center">
  Matacuás2016
  
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