function visSel()
{
	var leg=document.getElementById("legajo");
	var la=document.getElementById("la");
	var boton=document.getElementById("boton");
	if(leg=="")
	{
		la.classList.remove("visible");
		la.classList.add("oculto");	

	}
	else
	{
		la.classList.remove("oculto");
		la.classList.add("visible");

	}

}

function visSel2()
{
	
	var boton=document.getElementById("boton");
	boton.classList.remove("oculto");
	boton.classList.add("visible");
	var boton2=document.getElementById("volver");
	boton2.classList.remove("oculto");
	boton2.classList.add("visible");
	
}