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
    	<h1 class="display-3 centrarTexto">	Reporte estado academico</h1>
	</div>
	<div class="centrar">
		<div class="row">
			<h3>Inscripciones actuales a cursos</h3>
		</div>
		<div class="row">
			<div class="col"><b>Curso</b></div>
			<div class="col"><b>Descripcion</b></div>
			<div class="col"><b>Fecha de inscripcion</b></div>
			<div class="col"><b>Estado</b></div>
			<div class="col"><b>Nota</b></div>
		</div>
		<% int id=Integer.parseInt(request.getParameter("sel1"));
    	System.out.println("id "+id);
		CtrlAlumno ca=new CtrlAlumno();
		Alumno al= ca.getOneAl(id);
		CtrlInscripcionCurso cic=new CtrlInscripcionCurso();
		ArrayList<InscripcionCurso> listInsCurso=cic.getAllInscripcionesCurso(al);
		if(listInsCurso.isEmpty()==false)
		{
			for(InscripcionCurso ic:listInsCurso){
			%>
		<div class="row">
			<div class="col"><%= ic.getCurso().getNombre()%></div>
			<div class="col"><%=ic.getCurso().getDescripcion() %></div>
			<div class="col"><%=ic.getFechainscripcion() %></div>
			<div class="col"><%=ic.getEstado() %></div>
			<div class="col"><%=ic.getNota() %></div>
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
		<div class="row">
			<h3>Inscripciones actuales a carrera</h3>
		</div>
		<div class="row">
			<div class="col-sm"><b>Carrera</b></div>
			<div class="col-sm"><b>Fecha de inscripcion</b></div>
		</div>
		<% 
		CtrlInscripcionCarrera cica=new CtrlInscripcionCarrera();
		ArrayList<InscripcionCarrera> listInsCar=cica.getAllInscripcionesCarrera(al);
		if(listInsCar.isEmpty()==false)
		{
			for(InscripcionCarrera icc:listInsCar){
			%>
		<div class="row">
			<div class="col-sm"><%= icc.getCarrera().getNombre()%></div>
			<div class="col-sm"><%=icc.getFechainscripcion() %></div>
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
		<div class="row">
			<h3>Cursos anteriores</h3>
		</div>
		<div class="row">
			<div class="col"><b>Curso</b></div>
			<div class="col"><b>Fecha de inscripcion</b></div>
			<div class="col"><b>Estado</b></div>
		</div>
		<% 
		ArrayList<InscripcionCurso> listaEstado=cic.getEstadoCursoAnterior(al);
		if(listaEstado.isEmpty()==false)
		{
			for(InscripcionCurso insc:listaEstado){
			%>
		<div class="row">
			<div class="col"><%= insc.getCurso().getNombre()%></div>
			<div class="col"><%=insc.getFechainscripcion() %></div>
			<div class="col"><%=insc.getEstado() %></div>
		</div>
		<% 			
		    }
		}
		else
		{%>
		<div class="row">
			<h6>No ha realizado otros cursos</h6>
		</div>	
		<% }%>
		<div class="row">
			<h3>Promedio general por carrera</h3>
		</div>
		<div class="row">
			<div class="col"><b>Carrera</b></div>
			<div class="col"><b>Promedio </b></div>
		</div>
		<% 
		HashMap<String,Integer> listadoNota=cic.getPromedio(al);
		
		if(listadoNota.isEmpty()==false)
		{%>
		<div class="row">
		<div class="col">
		<%
			for(String i:listadoNota.keySet()){
			%>
	
			<div class="row"><%= i%></div>
		<% 			
		    } %>
		</div>
		<div class="col">
		<%
			for(int j:listadoNota.values()){ %>
							
			<div class="row"><%= j%></div>
		
			<%} %>
		</div>
		<%
		}
		else
		{%>
		<div class="row">
			<h6>No ha realizado otros cursos</h6>
		</div>	
		<% }%>
		</div>
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
