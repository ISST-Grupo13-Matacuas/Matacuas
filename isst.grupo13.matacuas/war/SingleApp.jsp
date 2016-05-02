<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<%@ include file="MenuSup.jsp" %>
<div class="row listTarjetas" id="listTarjetas">
              			<c:if test="${not empty quejas }">
              				<c:forEach items="${quejas}" var="queja">
								
								<a class="tarjetaHtml" href="/verQueja?id=${queja.id }"   >
										<c:if test="${queja.tipo==1 }" >
									   <div class=" row well animated pulse tarjeta" style="border: solid 0.5vh #C55;" >
									   </c:if>
									   <c:if test="${queja.tipo== 2}">
									   <div class=" row well animated pulse tarjeta" style="border: solid 0.5vh #5C5;" >
									   </c:if>
									   <div class="col-xs-4 col-sm-3">
									   <c:choose>
											<c:when test="${queja.imagen.value != ''}">
												<img class="img img-responsive img-rounded imgTarjeta" src="${queja.imagen.value}" alt=""></div>
											</c:when>
											<c:otherwise>
												<img class="img img-responsive img-rounded imgTarjeta" src="/images/car.jpg" alt=""></div>
											</c:otherwise>
										</c:choose>
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