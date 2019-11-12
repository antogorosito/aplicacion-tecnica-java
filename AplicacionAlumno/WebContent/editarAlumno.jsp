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
    	<h1 class="display-3 centrarTexto">Edicion de datos de alumnos</h1>
	</div>
	<div class="centrar ">
			<form action="editar" method="post">	
				<% int id=Integer.parseInt(request.getParameter("sel1"));
    		System.out.println("id "+id);
			CtrlAlumno ca=new CtrlAlumno();
				Alumno al= ca.getOneAl(id);
				%>
				<div class="">
					<label><b>Nombre:</b></label>
					<input type="text" class="form-control" id="nombre" name="nombre"   maxlength=40 value=<%=al.getPersona().getNombre()%>>
				</div>
				<div class="">
					<label><b>Apellido:</b></label>
					<input type="text" class="form-control" id="apellido" name="apellido"   maxlength=40 value=<%=al.getPersona().getApellido()%>>
				</div>
				<div class="">
					<label><b>Domicilio:</b></label>
					<input type="text" class="form-control" id="direccion" name="direccion"  maxlength=80 value=<%=al.getPersona().getDireccion()%>>
				</div>
				<div class="">
					<label><b>Fecha de nacimiento:</b></label>
					<input type="date" class="form-control" id="fechanac" name="fechanac"   min="1920-01-01" value=<%=al.getPersona().getFechanac()%>>
				</div>
				<div class="">
					<label><b>Tipo documento:</b></label>
					<select class="form-control" id="tipodoc" name="tipodoc">
				  	 	<% 
				  	 	for(TipoDoc tipo:TipoDoc.values())
				  	 	{
				  	 		if(tipo==al.getPersona().getTipodoc())
				  	 		{%>
					   		<option value=<%=tipo.getValor()%> selected><%=tipo%></option>
					   		<% } 
					   		else
					   		{%>
					   		<option value=<%=tipo.getValor()%> ><%=tipo%></option>
					   		<%}
				  	 		} %> 
					</select>
				</div>
				<div class="">
					<label><b>Fecha de nacimiento:</b></label>
					<input type="number" class="form-control" id="nrodoc" name="nrodoc" value=<%=al.getPersona().getDocumento()%>>
				</div>
				<div class="">
					<label><b>Legajo:</b></label>
					<input type="number" class="form-control" id="legajo" name="legajo" value=<%=al.getLegajo()%>>
				</div>
				<div class=" oculto">
					<input type="number" class="form-control" id="idp" name="idp" value=<%=al.getPersona().getIdPersona()%>>
				</div>
				<div class=" oculto">
					<input type="number" class="form-control" id="ida" name="ida" value=<%=al.getIdAlumno()%>>
				</div>
				<div class="top" >
					<button type="submit" class="col-20 btn btn-success" name="op" value="guardar">Guardar</button>	
					<button type="submit" class="col-20 btn btn-success"name="op" value="volver" formnovalidate>Volver</button>	
				</div>			
			</form> 
    </div>

</body>
</html>
