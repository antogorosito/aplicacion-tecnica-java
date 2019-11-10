/**
 * 
 */
$('#sel1').on('click',function(){
	alert("entre");
	if($('#sel1').val()==0)
	{ alert("entre2");
		$('#lala').removeClass('visible').addClass('oculto');
	}
	else
	{ alert("entre 3");
		$('#lala').removeClass('oculto').addClass('visible');
	}
});

function funt()
{

		$('#pepe').removeClass('red');
	
}