<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page
	import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%
	BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="MenuSup.jsp"%>
<div class="main col-md-10 col-md-offset-2">

	<!--aqui el contenido-->
	<div id="payLoadSP">
	
	
		<c:if test="${not empty  user && user!= null && not empty usuarioBD }">

			<div class="row listTarjetasPerf ">
<div class="col-xs-12 text-center">
				<div class=" row well tarjeta">
						<div class="col-xs-12 col-sm-10 col-sm-offset-1">
							<div class="row">								
								<div class="col-xs-12 text-center">
									<h3>Información</h3>
								</div>
								<div class="col-xs-12">
									<form role="form"
										action="<%=blobstoreService.createUploadUrl("/ajustes")%>"
										method="post" acceptcharset="utf-8"
										enctype="multipart/form-data">
										<div class="form-group">
											<label class="control-label " for="alias">Nickname:</label>
											<div class="col-sm-10">
												<input type="text" autocomplete="off" class="form-control"
													id="nick" name="nick" placeholder="${usuarioBD.nick }">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label " for="mail">Matrícula:</label>
											<div class="col-sm-10">
												<input type="text" maxLength="7" autocomplete="off"
													class="form-control" id="matricula" name="matricula"
													placeholder="${usuarioBD.matricula }">
											</div>
										</div>
										<div class="form-group">
										  <label for="imagenPerfil"> <span class="btn btn-login btn-block">Imagen</span></label>
    												<input style="visibility: hidden;height: 0px;" id="imagenPerfil" class="form-control" type="file" name="imagenPerfil">
										</div>
										<input type="submit" name="submit" id="submit"
											value="Guardar cambios" class="btn  btn-login pull-right">
									</form>
								</div>
							</div>
						</div>
					</div>
				
					</div>
				
					</div>
			</div>

		</c:if>
		<%@ include file="MenuInf.jsp"%>