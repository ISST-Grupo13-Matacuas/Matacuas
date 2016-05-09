<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp"%>

<div class="main col-sm-12 col-md-10 col-md-offset-2">

	<!--aqui el contenido-->
	<div id="payLoadSP">

		<c:if test="${not empty  user && user!= null && not empty usuarioBD }">

			<div class="row" style="min-height: 19vh">
				<div id="CajaImagen"></div>
				<div class="nopad">
					<div class="col-xs-6 col-xs-offset-3 col-sm-4 col-sm-offset-4 col-md-3 col-md-offset-1 col-lg-2 col-lg-offset-1">
						<c:choose>
							<c:when test="${usuarioBD.imagen != '' }">
								<img src="/imagenUsuario" alt=""
									class="img img-responsive imgTarjeta img-circle img-perfil imgPerf">
							</c:when>
							<c:otherwise>
								<img src="https://randomuser.me/api/portraits/med/men/44.jpg"
									alt=""
									class="img img-responsive imgTarjeta img-circle img-perfil imgPerf">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-xs-8 col-xs-offset-1 col-sm-9 col-sm-offset-1 col-md-6 col-md-offset-1 col-lg-8 col-lg-offset-0" id="cajaInfoUser">
						<c:if test="${ empty usuarioBD.nick }">
							<h4 class="nombrePerfil text-center"> <c:out value="${usuarioBD.usuario }" /> </h4>
							<a href="/ajustes">¡Elige un nickname!</a>
						</c:if>
						<h4 class="nombrePerfil"> <c:out value="${usuarioBD.nick }" /> </h4>
						<hr style="height: 0.05vh; background-color: rgba(59, 65, 97, 1);">						
						<c:if test="${empty usuarioBD.matricula }">
							<a href="/ajustes">¡Registra tu matrícula!</a>
						</c:if>						
						<p> <c:out value="${usuarioBD.matricula }" /> </p>
					</div>
					<div class="col-xs-1" id="cajaAjustes">
						<a href="/ajustes"><span class="glyphicon glyphicon-cog cogGly"></span> </a>
					</div>
				</div>
			</div>

			<div class="row nopad" id="botoneraPerfil">
				<div class="col-xs-4 nopad">
					<button class="btn btn-block" style="background-color: #AAC">Todos</button>
				</div>
				<div class="col-xs-4 nopad">
					<button class="btn btn-block" style="background-color: #5C5">Positivos</button>
				</div>
				<div class="col-xs-4 nopad">
					<button class="btn btn-block" style="background-color: #C55">Negativos</button>
				</div>
			</div>




			<div class="row listTarjetasPerf nopad" id="">
				<div id="ProfileList">

					<c:if test="${not empty quejasUsuario }">

						<c:forEach items="${quejasUsuario}" var="queja">
							<a class="tarjetaHtml" href="/verQueja?id=${queja.id }">
								 <div class=" row well tarjeta" style="border: solid 0.5vh <c:if test="${queja.tipo==1 }">#C55</c:if><c:if test="${queja.tipo==2 }">#5C5</c:if>;">
									<div class="col-xs-4 col-sm-3 col-md-2">
										<c:choose>
											<c:when test="${queja.imagen != null and queja.imagen != ''}">
												<img class="img img-responsive img-rounded imgTarjeta" src="/imagen?id=${queja.id}" alt="">
											</c:when>
											<c:otherwise>
											<c:set var="rand"><%= (int) java.lang.Math.ceil(java.lang.Math.random() * 5) %></c:set>
												<img class="img img-responsive img-rounded imgTarjeta" src="/images/${rand}.jpg" alt="">
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-xs-6 col-sm-7">
										<h3 class="tarjetaTitle">
											<c:out value="${queja.lugar }" />
										</h3>
										<p>
											<small>Vehículo con matrícula <c:out
													value="${queja.matricula }" /></small>
										</p>
										<p>
											<small><c:out value="${queja.descripcion }" /></small>
										</p>
									</div>
								</div>
							</a>
						</c:forEach>
					</c:if>
				</div>
			</div>

</c:if>



<%@ include file="MenuInf.jsp"%>