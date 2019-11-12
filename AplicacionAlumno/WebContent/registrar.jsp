<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.*" %>
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
    	<h1 class="display-3 centrarTexto">Registración de alumnos</h1>
	</div>
	<div class="centrar ">
			<form action="registrar" method="post">	
				<div class="">
					<label><b>Nombre:</b></label>
					<input type="text" class="form-control" maxlength=40 id="nombre" name="nombre" required>
				</div>
				<div class="">
					<label><b>Apellido:</b></label>
					<input type="text" class="form-control"  maxlength=40 id="apellido" name="apellido" required>
				</div>
				<div class="">
					<label><b>Tipo documento:</b></label>
					<select class="form-control" id="tipodoc" name="tipodoc">
				  	 	<%for(TipoDoc tipo:TipoDoc.values()){  %>
					   		<option value=<%=tipo.getValor()%>><%=tipo%></option>
					   		<% } %> 
					</select>
				</div>
				<div class="">
					<label><b>Documento:</b></label>
					<input type="number" class="form-control" id="nrodoc" name="nrodoc" required>
					<div class="text-hide red" id="nroDocError">Debe tener 7 u 8 digitos el documento.</div>
				</div>
				<div class="">
					<label><b>Fecha de nacimiento:</b></label>
					<input type="date" class="form-control" id="fechanac" name="fechanac" min="1920-01-01" required>
					<div class="text-hide red" id="fechaError">Debe ser menor a la fecha actual.</div>
				</div>
				<div class="">
					<label><b>Direccion:</b></label>
					<input type="text" class="form-control"  maxlength=80 id="direccion" name="direccion" required>
				</div>
				<div class="">
					<label><b>Legajo:</b></label>
					<input type="number" class="form-control" id="legajo" name="legajo" required>
				</div>
				
				<div class="top">
					<button type="submit" class="col-20 btn btn-success" >Registrar</button>
				</div>
			</form>
		</div>

	
</body>
</html>
