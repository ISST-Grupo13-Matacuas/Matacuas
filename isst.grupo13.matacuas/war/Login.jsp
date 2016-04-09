<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <link rel="stylesheet" href="stylesheet/basico.css">


    <!-- Custom styles for this template -->
    <style>
   


    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:if test="${user!=null}">
		<c:out value="${user}"/> 
	</c:if>
<p>Puedes pulsar el siguiente enlace para salir
<a href="<c:url value="${url}"/>"></a></p>

 <div class="container-fluid">
      <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4  well animated bounceInDown" id="loginBox" >
        <div class="row"></div>
        <div class="col-xs-11 col-xs-offset-1 LoginText "><h1>LOGIN CON GOOGLE</h1></div>
        <div class="col-xs-12 hrBar" ><hr></div>

        
        <div class="col-xs-12">
          <div class="col-xs-12">
            
            <a href="<c:url value="${url}"/>" >
            <button class="btn btn-block btn-login" type="submit" >
              Log in
            </button>
            </a>
          
          </div>
          

        </div>

      </div>

    </div>



  </div>
  <!-- /.container -->

  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

</body>
</html>