package negocio;
import database.*;
import entidades.*;

public class CtrlDocente
{
	private DataDocente dd;
	public CtrlDocente()
	{
		dd=new DataDocente();
	}
	public Docente getDocente(int idcurso) throws AppDataException
	{
		return dd.getDocente(idcurso);
	}
}
