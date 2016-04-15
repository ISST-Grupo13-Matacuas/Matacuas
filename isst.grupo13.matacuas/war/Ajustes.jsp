<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp" %>

<c:if test="${not empty  user && user!= null && not empty usuarioBD }">

<div class="row listTarjetasPerf">


   <div class=" row well animated pulse tarjeta">
   <div class="row">
   <div class="col-xs-12 col-sm-4">
   <div class="row">
   <div class="col-xs-6 col-sm-12">
   <img src="https://randomuser.me/api/portraits/med/men/44.jpg" alt="" class="img img-responsive imgTarjeta img-circle">
   </div>
   <div class="col-xs-6  col-sm-12">
    <h2>change image</h2>
   </div>
   </div>
   </div>
   <div class="col-xs-12 col-sm-8">
  <div class="row">
   <div class="col-xs-12 text-center">
   <h3>Información</h3>
   </div>

   <div class="col-xs-12">
   <form role="form" action="/ajustes" method="post" acceptcharset="utf-8">
   
   <div class="form-group">
   <label class="control-label col-sm-2" for="alias">Nickname:</label>
   <div class="col-sm-10">
   <input type="text" autocomplete="off" class="form-control" id="nick" name="nick" placeholder="${usuarioBD.nick }" >
   </div>
   </div>
   <!--  
   <div class="form-group">
   <label class="control-label col-sm-2" for="bio">Bio:</label>
   <div class="col-sm-10">
   <textarea class="form-control" rows="4"  placeholder="Conduzco mi Taxi mientras escucho los partidos del equipo de mi barrio por la radio!" ></textarea>
   </div>
   </div>
   -->
   <div class="form-group">
   <label class="control-label col-sm-2" for="mail">Matrícula:</label>
   <div class="col-sm-10">
   <input type="text" maxLength="7" autocomplete="off" class="form-control" id="matricula" name="matricula" placeholder="${usuarioBD.matricula }">
   </div>
   </div>
    <input type="submit" name="submit" id="submit" value="Guardar cambios" class="btn  btn-login pull-right">

	<!--  
   <hr>
   <div class="col-xs-12 text-center">
   <h3>Notificaciones</h3>
   </div>
   <div class="form-group">
   <div class="col-xs-4 col-xs-offset-4">
   <input type="checkbox" data-toggle="toggle" data-on="activas" data-off="inactivas" id="not" data-onstyle="success" data-offstyle="danger">
   </div>
   </div>
   <hr>
   -->
   
</form>
   </div>
   </div>
   </div>

   </div>


   </div>
   </div>

</c:if>
<%@ include file="MenuInf.jsp" %>