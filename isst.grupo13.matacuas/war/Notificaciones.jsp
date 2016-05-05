<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>
 <div class="main col-md-10 col-md-offset-2">
            
            <!--aqui el contenido-->
              <div id="payLoadSP">
<c:if test="${not empty  user && user!= null && not empty usuarioBD }" >

	<div class="row listTarjetasPerf">
	
	<c:if test="${not empty quejasMatricula }">
        <c:forEach items="${quejasMatricula}" var="queja">
	
	    	<div id="ProfileList">
	    	
	    			<a class="tarjetaHtml" href="/verQueja?id=${queja.id }">
	    				<c:if test="${queja.tipo==1 }" >
				   			<div class=" row well animated pulse tarjeta"  style="border: solid 0.5vh #C55;">
				   		</c:if>
				   		<c:if test="${queja.tipo== 2}">
							<div class=" row well animated pulse tarjeta" style="border: solid 0.5vh #5C5;" >
						</c:if>
				   			<div class="col-xs-4 col-sm-3">
				  		 	<c:choose>
								<c:when test="${queja.imagen != null}">
									<img class="img img-responsive img-rounded imgTarjeta" src="/imagen?id=${queja.id}" alt=""></div>
								</c:when>
								<c:otherwise>
									<c:set var="rand"><%= (int) java.lang.Math.ceil(java.lang.Math.random() * 5) %></c:set>
									<img class="img img-responsive img-rounded imgTarjeta" src="/images/${rand}.jpg" alt=""></div>
								</c:otherwise>
							</c:choose>
				  		
				  		 <div class="col-xs-8 col-sm-9">
				  			 	<h2 class="tarjetaTitle"><c:out value="${queja.lugar }"/></h2>
				   				<p class="textOver"><c:out value="${queja.descripcion }"/></small></p>
				
				   		</div>  
				   		<div class="col-xs-10  text-center">
				   		<c:if test="${queja.tipo==1 and queja.estado==1 }" >
				   		<div class="toolsCard"><a href="/reclamar?id=${queja.id }"><span class="glyphicon glyphicon-pencil"></span></div></a>
				   		</c:if>
				   		<c:if test="${queja.tipo==1 and queja.estado ==2 }">
				   			<p>Pendiente de decisión</p>
				   		</c:if>
				   		<c:if test="${queja.tipo==1 and queja.estado ==3 }">
				   			<p>Reclamación rechazada</p>
				   		</c:if>
				   		<c:if test="${queja.tipo==1 and queja.estado ==4 }">
				   		
				   		
				   		<form  role="form" action="/borrarQueja?id=${queja.id}" method="post" acceptcharset="utf-8" >
						 <input type="submit" name="submit" id="submit" value="reclamación aceptada puedes borrar la reclamación del sistema pulsando aqui" >
								
						
						</input>
					</form>
					
				   		
				   		</c:if>
				   		</div>
				  		 </div>
				   </a>
	    	
	    	</div>
    	
    	</c:forEach>
    	</c:if>
    </div>

</c:if>

<%@ include file="MenuInf.jsp" %>