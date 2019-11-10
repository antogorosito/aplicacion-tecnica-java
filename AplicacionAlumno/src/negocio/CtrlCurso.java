package negocio;
import java.util.ArrayList;

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

	public Curso getOne(int id)
	{
		return dc.getOne(id);
	}

}
