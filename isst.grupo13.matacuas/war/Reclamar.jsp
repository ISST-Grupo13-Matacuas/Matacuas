

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<%@ include file="MenuSup.jsp"%>

<div class="caja col-xs-8 col-xs-offset-2 text-center  well animated bounceInDown" style="border: solid 0.5vh #C55;">
	<div class="row">
		<h1 class="LoginText">Nueva Reclamación</h1>

		<form role="form" action="/reclamar" method="post" acceptcharset="utf-8" >
			<div class="col-xs-10 col-xs-offset-1"">
				
				<label>Razón de su reclamación</label>
				<br>
				<select id="razon" name="razon">
					<option value="1">No es mi matrícula</option>
					<option value="2">No estaba allí</option>		
					<option value="3">No soy yo</option>				
				</select>
				<br>
				<br>
				<br>
				<label>Descripción</label>
				<div class="input-group">
					<textarea name="descripcion" id="descripcion" class="form-control"
						rows="5" required placeholder="Descripción del incidente"></textarea>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
				<div class="form-group hidden">
                        
                        <div class="input-group">
                            <input type="hidden" class="form-control" name="id" id="id"  value="${id }">
                        </div>
                        
                    </div>
				


				<input type="submit" name="submit" id="submit" value="Reclamar"
					class="btn  btn-login">
			</div>
		</form>

	</div>

</div>
<!--acaba el contenido -->
</div>
</div>
</div>
<!-- /.container -->

<!-- Bootstrap core JavaScript
  ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="js/sidebar.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>

<script src="js/main.js?v=38"></script>

</body>
</html> 