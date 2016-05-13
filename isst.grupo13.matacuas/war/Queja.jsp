<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>
 <div class="main col-xs-12 col-md-10 col-md-offset-2 nopad">
            
            <!--aqui el contenido-->
              <div id="payLoadSP">
	<c:if test="${not empty quejaAVer and quejaAVer!=null }">
	
		<div class="row historia">
		<div class="col-xs-12 nopad">
		<div class="wrapper" >
		
		
		<div id="mapa"></div>

		</div>
				</div>
			<div class="col-xs-12 ">
		<div class="row">
		
		<div class="col-xs-12 col-md-6">
		<h1 class="tarjetaTitle text-center" id="lugar"><c:out value="${quejaAVer.lugar }"/></h1>

		<hr class="hr">

		<p id="descripcion"><c:out value="${quejaAVer.descripcion }"/></p>
		<p>Matrícula: <c:out value="${quejaAVer.matricula }"/></p>
		<button class="btn btn-twitter" onclick="compartirTw('${quejaAVer.id }')"><i class = "fa fa-twitter"></i></button>
		</div>
		<div class="col-xs-12 col-md-6">
		<c:choose>
			<c:when test="${quejaAVer.imagen != null}">
				<img class="img img-responsive img-rounded imgDetalle" src="/imagen?id=${quejaAVer.id}" alt=""></div>
			</c:when>
			<c:otherwise>
				<c:set var="rand"><%= (int) java.lang.Math.ceil(java.lang.Math.random() * 5) %></c:set>
				<img class="img img-responsive img-rounded imgDetalle" src="/images/${rand}.jpg" alt=""></div>
			</c:otherwise>
		</c:choose>
		</div>
		
		</div>
		</div>
		<div class="col-xs-12 col-sm-6">
		

		<div class="row">
		<div class="col-xs-10 col-xs-offset-1" >
		
		<p id="latitudQueja" class="hidden"><c:out value="${quejaAVer.lat }"/></p>
		<p id="longitudQueja" class="hidden"><c:out value="${quejaAVer.lng }"/></p>

		

		</div>
		</div>

		</div>
		</div >
	
	
	</c:if>
	


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
  
  var lugar = document.getElementById("lugar").innerHTML;
  var descripcion = '<c:out value="${quejaAVer.descripcion }"/>';//document.getElementById("descripcion").innerText;
  var n = 120 - lugar.length;
  descripcion = descripcion.substr(0, n);
  var texto = "En "+lugar+": "+descripcion;
  
  function compartirTw(idQ) {	
	  console.log(idQ);
	  var via = "matacuas";
	  var newUrl = "https://twitter.com/intent/tweet?url=http://1-dot-isst-grupo13-matacuas-1271.appspot.com/verQueja?id="+idQ+'&';

	  var texMoc = texto + ' http://1-dot-isst-grupo13-matacuas-1271.appspot.com/verQueja?id='+idQ+' via '+via;

	  var diff = texMoc.length-140;

	  var newTexto = texto.slice(0,texto.length-diff);

	  newUrl = newUrl+'text='+newTexto+'&via=matacuas';

	  window.open(newUrl);
	  }
 
  var lat = document.getElementById("latitudQueja").innerHTML;
  var lng = document.getElementById("longitudQueja").innerHTML;
  var position = {lon: lng, lat:lat};
     $( document ).ready(create_map(0, position))
  </script>
</body>
</html>