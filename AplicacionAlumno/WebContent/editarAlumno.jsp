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
	<script src="javascript/editar.js" type="text/javascript"></script>
</head>
<body>   
    <div class="jumbotron fondo">
    	<h1 class="display-3 centrarTexto">Edicion de datos de alumnos</h1>
	</div>
	<div class="centrar">
			<form class="form-bus" action="editar" method="post">	
				<% int id=Integer.parseInt(request.getParameter("sel1"));
    		System.out.println("id "+id);
			CtrlAlumno ca=new CtrlAlumno();
				Alumno al= ca.getOneAl(id);
				%>
				<div class="form-group">
					<label>Nombre:</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value=<%=al.getPersona().getNombre()%>>
				</div>
				<div class="form-group">
					<label>Apellido:</label>
					<input type="text" class="form-control" id="apellido" name="apellido" value=<%=al.getPersona().getApellido()%>>
				</div>
				<div class="form-group">
					<label>Domicilio:</label>
					<input type="text" class="form-control" id="direccion" name="direccion" value=<%=al.getPersona().getDireccion()%>>
				</div>
				<div class="form-group">
					<label>Fecha de nacimiento:</label>
					<input type="date" class="form-control" id="fechanac" name="fechanac" value=<%=al.getPersona().getFechanac()%>>
				</div>
				<div class="form-group">
					<label>Tipo documento:</label>
					<input type="text" class="form-control" id="tipodoc" name="tipodoc" value=<%=al.getPersona().getTipodoc()%>>
				</div>
				<div class="form-group">
					<label>Fecha de nacimiento:</label>
					<input type="number" class="form-control" id="nrodoc" name="nrodoc" value=<%=al.getPersona().getDocumento()%>>
				</div>
				<div class="form-group">
					<label>Legajo:</label>
					<input type="number" class="form-control" id="legajo" name="legajo" value=<%=al.getLegajo()%>>
				</div>
				<div class="form-group oculto">
					<input type="number" class="form-control" id="idp" name="idp" value=<%=al.getPersona().getIdPersona()%>>
				</div>
				<div class="form-group oculto">
					<input type="number" class="form-control" id="ida" name="ida" value=<%=al.getIdAlumno()%>>
				</div>
				<div class="form-group row" >
					<button type="submit" class="col-20 btn btn-success">Guardar</button>		
				</div>			
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
