<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<%@ include file="MenuSup.jsp" %>
	<c:if test="${not empty user and not empty reclamaciones }">
	<div class="row listTarjetas" id="listTarjetas">
	<c:forEach items="${reclamaciones}" var="reclamacion">
	
	<div class=" row well animated pulse tarjeta"  >
					<a href="#terminarReclamacionReject" >
					<div class="col-xs-2 col-sm-3 text-center" style="background-color: rgb(204, 85, 85); font-size: 3em; color: #333;position: relative; height: 100%; border-radius: 2em 2em 2em 0em">
					<br>
					<span class="glyphicon glyphicon-remove"></span>
					 </div>
					  </a>
						 <div class="col-xs-8 col-sm-6 text-center">
					  <h2 class="tarjetaTitle"><a href="/verQueja?id=${reclamacion.idQueja }" >Queja reclamada</a> </h2>
					  <p class="textOver">Razón: <c:out value="${reclamacion.razon}"/></p>
				   <p class="textOver"><c:out value="${reclamacion.descripcion }"/></small></p>
									
					   </div>  
					   <a href="#terminarReclamacionAcept" >
					   	<div class="col-xs-2 col-sm-3 text-center" style="background-color: rgb(85, 204, 85); font-size: 3em; color: #333; position: relative; height: 100%;border-radius: 2em 0em 2em 2em">
					   	<br>
					<span class="glyphicon glyphicon-ok"></span>
					 </div>
					 </a>
	</c:forEach>
	
	</div>
	</c:if>



 <%@ include file="MenuInf.jsp" %>