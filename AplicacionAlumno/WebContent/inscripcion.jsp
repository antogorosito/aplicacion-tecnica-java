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
      <link href="style/bootstrap.min.css" rel="stylesheet">
    <link href="style/jumbotron.css" rel="stylesheet">
        <link href="style/estilo.css" rel="stylesheet">
	<script src="javascript/inscripcion.js" type="text/javascript"></script>
</head>
<body>   
    <div class="jumbotron fondo">
    	<h1 class="display-3 centrarTexto">Inscripcion a materia</h1>
	</div>
	<div class="centrar ">
		<form class="form-bus" action="inscripcion" method="post">	
			<div class="form-group">
				<label><b>Legajo:</b></label>
				<input type="number" class="form-control tamaño" id="legajo" name="legajo" onchange="visSel()" required>
			</div>
			<div class="form-group oculto " id="la">
				<label for="sel1"><b>Seleccionar un curso:</b></label>
			  	<select class="form-control" id="sel1" name="sel1"  onchange="visSel2()">
			  	 	<option value="0">Elige una opción</option>
				    <% CtrlCurso cc=new CtrlCurso();
				      ArrayList<Curso> listado=cc.getAll();
				      for(Curso cu: listado) {
				   %>
				   			<option value=<%=cu.getIdCurso() %>><%=cu.getNombre()%></option> 
				   <%} %>
				</select>
			</div>
			<button type="submit" class="col-20 btn btn-success oculto" id="boton" name="op" value="inscribir">Inscribir</button>
			<button type="submit" class="col-20 btn btn-success oculto" id="volver"name="op" value="volver" formnovalidate>Volver</button>
			
		</form>
		
    </div>

</body>
</html>
