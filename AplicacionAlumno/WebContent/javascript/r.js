/**
 * 
 */

function visSel()
{
	alert("j");
	//window.location.replace("inscripcion.jsp?name="+name);
	var leg=document.getElementById("legajo");
	if(leg=="")
	{
		var la=document.getElementById("la");
		la.classList.remove("visible");
		la.classList.add("oculto");
	}
	else
	{
		var la=document.getElementById("la");
		la.classList.remove("oculto");
		la.classList.add("visible");
	}
	
}