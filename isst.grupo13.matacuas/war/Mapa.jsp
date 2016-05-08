<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>

        <div class="main col-md-10 col-md-offset-2 nopad">
            
            <!--aqui el contenido-->
              <div id="payLoadSP">
<c:if test="${not empty quejas and not empty coordenadas }">
              				<c:forEach items="${coordenadas}" var="coord">
              					<p class="latitudes hidden"><c:out value="${coord.lat }"/></p>
              					<p class="longitudes hidden"><c:out value="${coord.lng }"/></p>
              					
              				</c:forEach>
              				
              				<div id="wrapperMapa" >
								<div id="mapa"></div
								</div>
              				
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
 <script src="js/mapa.js?v=3"></script>

  <script src="js/main.js?v=39"></script>
  <script>
		var latitudes = document.getElementsByClassName("latitudes");
		var longitudes = document.getElementsByClassName("longitudes");
		//console.log("Latitudes: " + latitudes[0].innerHTML);
		//console.log("Longitudes: " + longitudes[0].innerHTML);
		var coordenadas = [];
		for (var i=0; i<latitudes.length; i++){
			coordenadas[i] = {lat: latitudes[i].innerHTML, lng: longitudes[i].innerHTML};
			console.log("Coordenada " +  i + " : Latitud: " + coordenadas[i].lat );
			console.log("Coordenada " +  i + " : Longitud: " + coordenadas[i].lng );
		}
		 $( document ).ready(create_map(0, 0, coordenadas));
		//console.log("Coordenadas: " + coordenadas[0].lng);
  
  </script>
</body>
</html>