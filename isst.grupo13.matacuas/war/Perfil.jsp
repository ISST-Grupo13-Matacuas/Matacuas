<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>

<c:if test="${not empty  user && user!= null && not empty usuarioBD }" >



<div class="row listTarjetasPerf">
   <div class=" row well animated pulse tarjeta">
   <div class="col-xs-4 col-xs-offset-4 box-img-perfil">
   <img src="https://randomuser.me/api/portraits/med/men/44.jpg" alt="" class="img img-responsive imgTarjeta img-circle img-perfil" style="position: absolute;">
   </div>
   <div class="col-xs-8" style="z-index: 100;">
   <br>
   <br>
   <br>
   <c:if test="${ empty usuarioBD.nick }">
   <h4 class="nombrePerfil text-center"><c:out value="${usuarioBD.usuario }"/></h4>
  		<a href="/ajustes">¡Elige un nickname!</a> 
   </c:if>
   <h4 class="nombrePerfil"><c:out value="${usuarioBD.nick }"/></h4>
   </div>
   <div class="col-xs-4 text-center">
   <br>
   
   </div>
   <br>
   <div class="col-xs-12">
   <br>
   <hr  style="height: 0.2vh;
   background-color: #26A4FF">
   </div>
  <div class="col-xs-12">
   <c:if test="${empty usuarioBD.matricula }">
   	<a href="/ajustes">¡Registra tu matrícula!</a>
   </c:if>
   <p><c:out value="${usuarioBD.matricula }"/></p>
   

   </div>  
   </div>

   <div class=" row well animated pulse tarjeta" >
   <div class="col-xs-4" ><button class="btn btn-block" style="background-color: #AAC">Todos</button></div>
   <div class="col-xs-4" ><button class="btn btn-block" style="background-color: #5C5">Positivos</button></div>
   <div class="col-xs-4" ><button class="btn btn-block" style="background-color: #C55">Negativos</button></div>
   </div>
   <div id="ProfileList">
   
   <c:if test="${not empty quejasUsuario }">
   
   			<c:forEach items="${quejasUsuario}" var="queja">
   			<a class="tarjetaHtml" href="/verQueja?id=${queja.id }">
   			 <c:if test="${queja.tipo==1 }" >
		          <div class=" row well animated pulse tarjeta" style="border: solid 0.5vh #C55;" >
		           </c:if>
		           <c:if test="${queja.tipo==2 }" >
		          <div class=" row well animated pulse tarjeta" style="border: solid 0.5vh #5C5;" >
		         </c:if>
				   <div class="col-xs-4 col-sm-3 col-md-2" >
				  <c:choose>
					<c:when test="${queja.imagen.value != ''}">
						<img class="img img-responsive img-rounded imgTarjeta" src="${queja.imagen.value}" alt=""></div>
					</c:when>
					<c:otherwise>
						<img class="img img-responsive img-rounded imgTarjeta" src="/images/car.jpg" alt=""></div>
					</c:otherwise>
				</c:choose>
				   </div>
				   <div class="col-xs-6 col-sm-7">
				   <h3 class="tarjetaTitle"><c:out value="${queja.lugar }" /></h3>
				   <p><small>Vehículo con matrícula <c:out value="${queja.matricula }"/></small></p>
				   <p><small><c:out value="${queja.descripcion }" /></small></p>
				
				   </div>
				   </a>  
				   
				   </div>
		   
		   </c:forEach>  				
		              				
   </c:if>
   
   
   </div>

   </div>
   
   </c:if>
   
   

<%@ include file="MenuInf.jsp" %>