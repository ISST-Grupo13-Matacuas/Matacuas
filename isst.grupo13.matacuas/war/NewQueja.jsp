<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<!DOCTYPE html>

<%@ include file="MenuSup.jsp" %>

<!--  limpio -->

 <div class="main col-md-10 col-md-offset-2">
 	<!--aqui el contenido-->
    <div id="payLoadSP">
    	<div class="row" id="">
			<c:if test="${not empty tipoQueja and (tipoQueja ==1 or tipoQueja==2) }">
					<div  class="caja col-xs-12 text-center  well animated bounceInDown nopad" style="border: solid 1vh <c:if test="${tipoQueja == 1 }">#C55</c:if><c:if test="${tipoQueja == 2 }">#5C5</c:if>;padding-top: 0%;min-height: calc(100vh - 115px);">
   						<div class="row">
   				
   							<div class="col-xs-12 col-xs-offset-0">
							 	<div class="wrapper">
							   		<div id="mapa">
							   		</div>
							   </div>
							</div>
							
							<div class="col-xs-4 col-xs-offset-8">
								<button class="btn-login btn" id="locate">Localízame!</button>
							</div>
							
							<div class="col-xs-12 text-center">
								 <h1 class="LoginText">	  <c:if test="${tipoQueja == 1 }">Nueva Queja </c:if><c:if test="${tipoQueja == 2}">Buena acción </c:if></h1>
 							</div>
													
							<div class="col-xs-12">
							 	<form  role="form" action="<%=blobstoreService.createUploadUrl("/newQueja") %>" method="post" acceptcharset="utf-8" enctype="multipart/form-data">
							 		<div class="row">
							 			<!-- SDASAD -->
							 			 <div class="col-xs-10 col-xs-offset-1">
							 			 
								 			 <div class="row">
								 			 
	                    						<!--  <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Obligatorio</strong></div>-->
	                   							 <div class="col-xs-12 col-sm-6">
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
							                        
							                        <label>Imagen</label>
							                        <div class="input-group">
							                            <input type="file" id="imagen" name="imagen" />
							                            <input type="hidden" id="imagenurl" name = "imagenurl"/>
							                    	</div>
							                    
							                    </div>	
												 	<div class="col-xs-12 col-sm-6">
								                        <label>Descripción</label>
								                        <div class="input-group">
								                            <textarea name="descripcion" id="descripcion" class="form-control" rows="5" required placeholder="Descripción del incidente"></textarea>
								                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>  
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
								                    
								                    </div>
								                    <div class="col-xs-12">
								                    	<input type="submit" name="submit" id="submit" value="Poner queja" class="btn  btn-login">
							                    	</div>
							                    	
						                    </div>
						                </div>
						 				<!-- ZXZCXZCZX-->	 		
							 		</div>
							 	</form>
							 </div>	
   		 				</div> 
   		  			</div> 
			</c:if>
        </div> 
	</div> <!-- -div payload -->
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
     $( document ).ready(create_map(1,0));
     document.getElementById('imagenurl').value= "/images/" + Math.ceil(Math.random()*5) + ".jpg";
     document.getElementById('imagen').addEventListener('change', function(){
        var file = this.files[0];
        var reader = new FileReader();
         reader.onload = function(){
          //console.log(reader.result);
          document.getElementById('imagenurl').value=reader.result;
          console.log(document.getElementById('imagenurl').value);
        };
        reader.readAsDataURL(file);
      }, false);
  </script>
</body>
</html>