<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="negocio.*"%>
<%@page import="entidades.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Gestion de alumnos</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/jumbotron/">

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/jumbotron.css" rel="stylesheet">
    <link href="style/estilos.css" rel="stylesheet">
	<script src="javascript/r.js" type="text/javascript"></script>
</head>
<body>   
    <div class="jumbotron fondo">
    	<h1 class="display-3 centrarTexto">Inscripcion a materia</h1>
	</div>
	<div class="centrar">
		<form class="form-bus" action="inscripcion" method="post">	
			<div class="form-group">
				<label>Legajo:</label>
				<input type="number" class="form-control tamaño" id="legajo" name="legajo" onblur="visSel()" required>
			</div>
			<div class="form-group oculto " id="la">
				<label for="sel1">Seleccionar un curso:</label>
			  	<select class="form-control" id="sel1" name="sel1">
			  	 	<option value="0">Elige una opción</option>
				    <% CtrlCurso cc=new CtrlCurso();
				      ArrayList<Curso> listado=cc.getAll();
				      for(Curso cu: listado) {
				   %>
				   			<option value=<%=cu.getIdCurso() %>><%=cu.getNombre()%></option> 
				   <%} %>
				</select>
			</div>
			<button type="submit" class="col-20 btn btn-success" >Inscribir</button>
			<%String msj=(String)request.getAttribute("error");
	 			if (msj != null) {%>
 					<label style="color:red;"><%=msj %></label>
 				<%}%>
		</form>
		
    </div>

	<footer class="fondo ">	
		<div class="footer-container">
			<div class="footer-main">
    			<p>Prueba Tecnica java- Gorosito,Antonella</p>
    		</div>
    	</div>
    </footer>
</body>
</html>
