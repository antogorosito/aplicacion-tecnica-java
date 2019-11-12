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
	
</head>
<body>   
    <div class="jumbotron fondo">
    	<h1 class="display-3 centrarTexto">Reporte de estado de alumno</h1>
	</div>
	<div class="centrar ">
			<form class="form-bus" action="reporteEstado" method="post">	
				<div class="form-group">
					<label for="sel1"><b>Seleccionar un alumno:</b></label>
				  	<select class="form-control" id="sel1" name="sel1">
				  	 	<option value="0">Elige una opción</option>
					    <% CtrlAlumno ca=new CtrlAlumno();
					      ArrayList<Alumno> listado=ca.getAll();
					      for(Alumno al: listado) {
					   %>
					   		<option value=<%=al.getLegajo() %>><%=al.getPersona().getNombre() +" "+ al.getPersona().getApellido()%></option>
					   <%} %>
					</select>
				</div>
				<button type="submit" class="col-20 btn btn-success" >Ver reporte</button>
			</form> 
    </div>

</body>
</html>
    