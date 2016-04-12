<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<%@ include file="MenuSup.jsp" %>
<div class="row listTarjetas" id="listTarjetas">
              			<c:if test="${not empty quejas }">
              				<c:forEach items="${quejas}" var="queja">
								
								<a class="tarjetaHtml" onclick="">
									   <div class=" row well animated pulse tarjeta" >
									   <div class="col-xs-4 col-sm-3">
									   <img src="/images/car.jpg" alt="" class="img img-responsive imgTarjeta">
									   </div>
									   <div class="col-xs-8 col-sm-9">
									   <h2 class="tarjetaTitle"><c:out value="${queja.lugar}"/> </h2>
									   <p class="textOver"><c:out value="${queja.descripcion }"/></small></p>
									
									   </div>  
									   </div>
									   </a>
									
									
									
							</c:forEach>
              			</c:if>
              		
              		</div> 
              		
   <%@ include file="MenuInf.jsp" %>