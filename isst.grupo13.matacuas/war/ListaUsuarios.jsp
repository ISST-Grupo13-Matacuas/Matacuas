<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>
<div class="main col-md-10 col-md-offset-2">
	<div  class="row listTarjetas" id="listTarjetas">
			<c:if test="${not empty user and usuarioBD.tipo == 1 and not empty usuariosSistema }">
				<c:forEach items="${usuariosSistema}" var="us">
  					<c:if test="${us.usuario != usuarioBD.usuario }">
					
							<div class=" row well animated pulse tarjeta" style="border: solid 0.5vh">
						<div class="col-xs-4 col-sm-3">
							 <c:choose>
			<c:when test="${usuarioBD.imagen != '' }">
				<img src="/imagenUsuario" alt="" class="img img-responsive imgTarjeta img-circle img-perfil">
			 </c:when>
			<c:otherwise>
				<img src="https://randomuser.me/api/portraits/med/men/44.jpg" alt="" class="img img-responsive imgTarjeta img-circle img-perfil" style="position: absolute;" >
			</c:otherwise>
		</c:choose>
						</div>

						<div class="col-xs-8 col-sm-9">
							<h2 class="tarjetaTitle">
								<c:out value="${us.nick}" />
							</h2>
							<p class="textOver">
								<c:out value="${us.usuario }" />
								</small>
							</p>
							<p class="textOver">
								Quejas borradas:
								<c:out value="${us.quejasBorradas }"/>
							</p>
							<p class="textOver">
								Reclamaciones rechazadas:
								<c:out value="${us.reclamacionesRechazadas }"/>
							</p>
							
							<c:choose>
							
							<c:when test="${!us.baneado }">
								<form method="post" action="/banear">
								<input type="text" name="email" class="hidden" value="${us.usuario }"/>
								<input type="text" name="decision" class="hidden" value="0"/>
								<input class ="btn btn-cancel" type="submit" value="Banear usuario"/>
							
							</form>
							
							</c:when>
							<c:otherwise>
							<form method="post" action="/banear">
								<input type="text" name="email" class="hidden" value="${us.usuario }"/>
								<input type="text" name="decision" class="hidden" value="1"/>
								<input class ="btn btn-success" type="submit" value="Admitir usuario"/>
							
							</form>
							
							</c:otherwise>
							
							</c:choose>
							
							
				
						</div>
					</div>
					</c:if>
					



				</c:forEach>
			</c:if>
</div>
</div>



 <%@ include file="MenuInf.jsp" %>