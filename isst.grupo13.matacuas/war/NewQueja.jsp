<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<%@ include file="MenuSup.jsp" %>

	<c:if test="${not empty tipoQueja and (tipoQueja ==1 or tipoQueja==2) }">
	
	
	<c:if test="${tipoQueja == 1 }">
	
<div  class="caja col-xs-8 col-xs-offset-2 text-center  well animated bounceInDown" style="border: solid 0.5vh #C55;">
   <div class="row">
   
   
   <h1 class="LoginText">
   
   		
   			Nueva Queja</h1>
   		</c:if>
   		
   		
   		<c:if test="${tipoQueja == 2 }">
   			
   			<div  class="caja col-xs-8 col-xs-offset-2 text-center  well animated bounceInDown" style="border: solid 0.5vh #5C5;">
  			 <div class="row">
   				 <h1 class="LoginText">
   			
   				Buena acción
   				</h1>
   			
   		</c:if>
   		
   		
   	
   
   
   <div class="row">
   <div class="col-xs-10 col-xs-offset-1">
   <button class="btn-login btn" id="locate">Localízame!</button>
   <div class="wrapper">
   <div id="mapa"></div>
   </div>
   </div>
   </div>
 
 <!--  
   <div class="row">
   <div class="col-xs-10 col-xs-offset-1">
   		<p id="lat">Latitud</p>
   		<p id="lng">Longitud</p>
   
   </div>
   </div>
   -->
   
   
   
 
   
   <form  role="form" action="/newQueja" method="post" acceptcharset="utf-8">
                <div class="col-xs-10 col-xs-offset-1"">
                    <!--  <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Obligatorio</strong></div>-->
                   
                        <label>Lugar</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="lugar" id="lugar" placeholder="Lugar del incidente" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                       
                        
                    </div>
                    
                        <label>Matrícula</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="matricula" id="matricula" placeholder="Matrícula del infractor" maxLength="7" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        
                    
                    
                    
                    
                        <label>Descripción</label>
                        <div class="input-group">
                            <textarea name="descripcion" id="descripcion" class="form-control" rows="5" required placeholder="Descripción del incidente"></textarea>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        
                        
                    </div>
                     
                        <label>Imagen</label>
                        <div class="input-group">
                            <input type="file" id="imagen" name="imagen" />
                           
                       
                        
                    </div>
                    <div class="form-group hidden">
                        
                        <div class="input-group">
                            <input type="hidden" class="form-control" name="latitud" id="latitud"  required>
                        </div>
                        
                    </div>
                    <div class="form-group ">
                        
                        <div class="input-group">
                            <input type="hidden" class="form-control" name="longitud" id="longitud"  required>
                        </div>
                        
                    </div>
                    <div class="form-group hidden">
                        
                        <div class="input-group">
                            <input type="hidden" class="form-control" name="tipo" id="tipo"  value="${tipoQueja }">
                        </div>
                        
                    </div>
                    <input type="submit" name="submit" id="submit" value="Poner queja" class="btn  btn-login">
                </div>
            </form>
<!--  
   <div class="row">
   <div class="col-xs-10 col-xs-offset-1">
   <form enctype="multipart/form-data">
   <div class="form-group">
   <input id="file-3" type="file" multiple=true>
   </div>
   <div class="form-group">
   <button class="btn  btn-login">Submit</button>
   <button class="btn  btn-gris" type="reset">Reset</button>
   </div>
   </form>
   </div>
   </div>
   -->
   
   </div>

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
 <script src="js/mapa.js"></script>

  <script src="js/main.js?v=38"></script>
  <script>
     $( document ).ready(create_map(1))
  </script>
</body>
</html>