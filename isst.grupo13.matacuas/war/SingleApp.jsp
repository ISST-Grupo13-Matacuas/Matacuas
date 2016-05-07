<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<%@ include file="MenuSup.jsp"%>
<div class="main col-md-10 col-md-offset-2">

	<!--aqui el contenido-->
	<div id="payLoadSP">

		<div class="row listTarjetas" id="listTarjetas">
			<c:if test="${not empty quejas }">
				<c:forEach items="${quejas}" var="queja">

					<a class="tarjetaHtml" href="/verQueja?id=${queja.id }"> 
						<c:if test="${queja.tipo==1 }">
							<div class=" row well animated pulse tarjeta"
								style="border: solid 0.5vh #C55;">
						</c:if>
						 <c:if test="${queja.tipo== 2}">
							<div class=" row well animated pulse tarjeta"
								style="border: solid 0.5vh #5C5;">
						</c:if>
						<div class="col-xs-4 col-sm-3">
							<c:choose>
								<c:when test="${queja.imagen != null && queja.imagen != ''}">
									<img class="img img-responsive img-rounded imgTarjeta"
										src="/imagen?id=${queja.id} " alt="">
								 </c:when>
								<c:otherwise>
									<c:set var="rand"><%= (int) java.lang.Math.ceil(java.lang.Math.random() * 5) %></c:set>
										<img class="img img-responsive img-rounded imgTarjeta"
											src="/images/${rand}.jpg" alt="">
								</c:otherwise>
							</c:choose>
						</div>

						<div class="col-xs-8 col-sm-9">
							<h2 class="tarjetaTitle">
								<c:out value="${queja.lugar}" />
							</h2>
							<p class="textOver">
								<c:out value="${queja.descripcion }" />
								</small>
							</p>
							<c:if test="${not empty user and not empty usuarioBD and  usuarioBD.tipo == 1 }">
							<form method="post" action="/borrarQueja">
								<input type="text" name="id" class="hidden" value="${queja.id }"/>
								<input class ="btn btn-cancel" type="submit" value="Borrar queja"/>
							
							</form>
							</c:if>
				
						</div>
					</div>
					</a>



				</c:forEach>
			</c:if>

	</div> <!-- div de row Lista tarjetas -->

<%@ include file="MenuInf.jsp"%>