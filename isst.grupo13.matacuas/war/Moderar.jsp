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
					
						 <div class="col-xs-8 col-sm-9">
					  <h2 class="tarjetaTitle"><a href="/verQueja?id=${reclamacion.idQueja }" >Queja reclamada</a> </h2>
					  <p class="textOver">Razón: <c:out value="${reclamacion.razon}"/></p>
				   <p class="textOver"><c:out value="${reclamacion.descripcion }"/></small></p>
									
					   </div>  
					   <div class="col-xs-4 col-sm-3">
						 
						 </div>
	</c:forEach>
	
	</div>
	</c:if>



 <%@ include file="MenuInf.jsp" %>