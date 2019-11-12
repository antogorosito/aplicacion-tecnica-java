package negocio;
import java.util.ArrayList;

import database.AppDataException;
import database.DataCurso;
import entidades.Curso;


public class CtrlCurso 
{
	private DataCurso dc;
	public CtrlCurso()
	{
		dc=new DataCurso();
	}
	public ArrayList<Curso> getAll()
	{
		return dc.getAll();
	}

	public Curso getOne(int id) throws AppDataException
	{
		return dc.getOne(id);
	}

}
