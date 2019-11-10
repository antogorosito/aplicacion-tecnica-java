<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="negocio.*"%>
<%@page import="entidades.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
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
    	<h1 class="display-3 centrarTexto">	Reporte de inscriptos al curso</h1>
	</div>
	<div class="centrar">
		<div class="row">
		<% CtrlCurso ctrlc=new CtrlCurso();
    		Curso cur=ctrlc.getOne(Integer.parseInt(request.getParameter("sel1")));%>
			<h3><%=cur.getNombre() %></h3>
		</div>
		<% CtrlInscripcionCurso cc=new CtrlInscripcionCurso();
    		ArrayList<InscripcionCurso> ic=cc.getInscriptos(Integer.parseInt(request.getParameter("sel1")));
    		CtrlPersona cp= new CtrlPersona();
    		Persona p=cp.getDocente(Integer.parseInt(request.getParameter("sel1")));%>
		<div class="row">
			<div class="col"><b>Docente</b></div>
			<div class="col"><%=p.getNombre()+" "+p.getApellido() %></div>
		</div>
		
		<div class="row">
			<div class="col"><b>Alumno</b></div>
			<div class="col"><b>Fecha de inscripcion</b></div>
		</div>
		<% 
		ArrayList<InscripcionCurso> listInsCurso=cc.getInscriptos(Integer.parseInt(request.getParameter("sel1")));
		if(listInsCurso.isEmpty()==false)
		{
			for(InscripcionCurso i:listInsCurso){
			%>
		<div class="row">
			<div class="col"><%= i.getAlumno().getPersona().getNombre()+" "+i.getAlumno().getPersona().getApellido()%></div>
			<div class="col"><%=i.getFechainscripcion() %></div>
		</div>
		<% 			
		    }
		}
		else
		{%>
		<div class="row">
			<h6>No posee inscripciones actuales</h6>
		</div>	
		<% }%>
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
