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

</head>
<body>   
    <div class="jumbotron fondo">
    	<h1 class="display-3 centrarTexto">Registración de alumnos</h1>
	</div>
	<div class="centrar">
			<form class="form-bus" action="registrar" method="post">	
			
				<div class="form-group">
					<label>Nombre:</label>
					<input type="text" class="form-control tamaño" id="nombre" name="nombre" required>
				</div>
				<div class="form-group">
					<label>Apellido:</label>
					<input type="text" class="form-control" id="apellido" name="apellido" required>
				</div>
				<div class="form-group">
					<label>Tipo documento:</label>
					<input type="text" class="form-control" id="tipodoc" name="tipodoc" required>
				</div>
				<div class="form-group">
					<label>Documento:</label>
					<input type="number" class="form-control" id="nrodoc" name="nrodoc" required>
				</div>
				<div class="form-group">
					<label>Fecha de nacimiento:</label>
					<input type="date" class="form-control" id="fechanac" name="fechanac" required>
				</div>
				<div class="form-group">
					<label>Direccion:</label>
					<input type="text" class="form-control" id="direccion" name="direccion" required>
				</div>
				<div class="form-group">
					<label>Legajo:</label>
					<input type="number" class="form-control" id="legajo" name="legajo" required>
				</div>
				<div class="form-group row" >
					<button type="submit" class="col-20 btn btn-success" data-toggle="modal" data-target="#registracion">Registrar</button>
					<div class="col-20">
						<%String msj=(String)request.getAttribute("errorLogin");
			  			if (msj != null) {%>
			 			<label style="color:red;"><%=msj %></label>
			 			<%}%>
					</div>		
				</div>
			</form> 
    </div>
	<div class="modal" id="registracion">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">Confirmacion</h4>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	      	Se ha cargado con exito un nuevo alumno
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal" id="cerrarModal">Cerrar</button>
	      </div>
	
	    </div>
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
