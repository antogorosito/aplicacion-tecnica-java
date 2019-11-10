package negocio;

import java.util.ArrayList;
import entidades.*;
import database.AppDataException;
import database.DataInscripcionCarrera;

public class CtrlInscripcionCarrera
{
	private DataInscripcionCarrera cic;
	public CtrlInscripcionCarrera()
	{
		cic=new DataInscripcionCarrera();
	}
	public ArrayList<InscripcionCarrera> getAllInscripcionesCarrera(Alumno al)
	{
		return cic.getAllInscripcionesCarrera(al);
	}
	public InscripcionCarrera validarCarreraCurso(int idal,int idcurso) throws AppDataException
	{
		return cic.validarCarreraCurso(idal,idcurso);
	}
}
