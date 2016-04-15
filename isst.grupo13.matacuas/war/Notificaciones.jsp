<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>

<c:if test="${not empty  user && user!= null && not empty usuarioBD }" >

	<div class="row listTarjetasPerf">
	
	<c:if test="${not empty quejasMatricula }">
        <c:forEach items="${quejasMatricula}" var="queja">
	
	    	<div id="ProfileList">
	    	
	    			<a class="tarjetaHtml" href="">
	    				<c:if test="${queja.tipo==1 }" >
				   			<div class=" row well animated pulse tarjeta"  style="border: solid 0.5vh #C55;">
				   		</c:if>
				   		<c:if test="${queja.tipo== 2}">
							<div class=" row well animated pulse tarjeta" style="border: solid 0.5vh #5C5;" >
						</c:if>
				   			<div class="col-xs-4 col-sm-3">
				  		 	<img src="/images/car.jpg" alt="" class="img img-responsive imgTarjeta">
				  		</div>
				  		 <div class="col-xs-8 col-sm-9">
				  			 	<h2 class="tarjetaTitle"><c:out value="${queja.lugar }"/></h2>
				   				<p class="textOver"><c:out value="${queja.descripcion }"/></small></p>
				
				   		</div>  
				  		 </div>
				   </a>
	    	
	    	</div>
    	
    	</c:forEach>
    	</c:if>
    </div>

</c:if>

<%@ include file="MenuInf.jsp" %>